package com.logiccity.minecraft.api.command;

import java.util.ArrayList;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.BuildStepRecord;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BuildPlay extends CustomModCommandBase {

	private ArrayList<BuildStepRecord> steps;
	private int idx = 0, yawI;
	private BlockPos currTarget = null;
	private BuildStepRecord currentRec = null;
	private boolean stepAttempted = false;
	private boolean shouldJumpBuild = false, isDestroy = false;
	
	private BuildPlay() {
		super("replay", 1);
	}
	
	@Override
	public void initCmd(String [] args) {
		idx = 0;
		stepAttempted = false;
		shouldJumpBuild = false;
		isDestroy = false;
		steps = gameInfo.loadRecordedBuildingSteps(args[0]);
	}
	@Override
	public void cleanupCmd() {
		steps = null;
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (stepAttempted) {
			if (isDestroy) {
				if (gameInfo.isSolid(currTarget)) {
					return false;
				}
			} else if (! gameInfo.isSolid(currTarget)) {
				int dx = currTarget.getX() - (int) Math.floor(gameInfo.getPlayerPosX()),
						dz = currTarget.getZ() - (int) Math.floor(gameInfo.getPlayerPosZ());
				if (dx != 0 || dz != 0) {
					if (Math.abs(dx) + Math.abs(dz) < 2.9) {
						GoToCmd.movePlayerX(gameControl, dx < 0, yawI);
						GoToCmd.movePlayerZ(gameControl, dz < 0, yawI);						
					} else {
						GoToCmd.resetControls(gameControl);
					}
					if (hasMillisPassed(200)) {
						buildRecordedStep();
					}
					return false;
				} else {
					shouldJumpBuild = true;
					idx --;
				}
			}
			stepAttempted = false;
			GoToCmd.resetControls(gameControl);
		}
		if (shouldJumpBuild) {
			gameControl.pressJumpKey();
//			System.out.println("|||bp:" + currTarget);
//			System.out.println("|||player@(" + player.posX + "," + player.posY + "," + player.posZ + ")");
			if (gameInfo.getPlayerPosY() - currTarget.getY() > 1) {
				buildRecordedStep();
				shouldJumpBuild = false;
				idx ++;
				gameControl.releaseJumpKey();
			} 
			return false;
		}
		if (idx < steps.size()) {
			if (gameInfo.isCommandRunning("goto") || gameInfo.isCommandRunning("turn")) {
				return false;
			}
			currentRec = steps.get(idx);
			isDestroy = currentRec.blockAction != null && (! currentRec.blockAction.isEmpty());
			currTarget = new BlockPos(currentRec.blockPos.x, currentRec.blockPos.y, currentRec.blockPos.z);
			if (! isDestroy) {
				currTarget = getTargetBlockPos(currTarget, currentRec.placeDir);
			}
					
			if (currTarget == null || (gameInfo.isSolid(currTarget) && (! isDestroy)) ||
					((! gameInfo.isSolid(currTarget)) && isDestroy) ) {
				idx ++;
				return false;
			}
			if (Math.floor(gameInfo.getPlayerPosX()) != Math.floor(currentRec.playerLoc.x) 
					|| Math.floor(gameInfo.getPlayerPosZ()) != Math.floor(currentRec.playerLoc.z)) {
				gameControl.executeCommand("goto", new String[] { String.valueOf(currentRec.playerLoc.x), 
						String.valueOf(currentRec.playerLoc.y), String.valueOf(currentRec.playerLoc.z)});
				return false;
			}
			yawI = Turn.getAxisesYaw(currentRec.playerYaw);
			if (Math.abs(gameInfo.getRotationYaw() - yawI) > 0.1) {
				gameControl.executeCommand("turn", new String[] {String.valueOf(yawI), String.valueOf(currentRec.playerPitch)});
				return false;
			}
			if (isDestroy) {
				destoryBlock();
				idx ++;
				return false;
			}
			if (gameControl.setPlayerCurrentItem(currentRec.currentItem)) {
				return false;
			}
			
			if (currTarget.equals(gameInfo.getLivingEntityLocation(null))) {
				shouldJumpBuild = true;
				return false;
			}
			buildRecordedStep();
			idx ++;
			return false;
		} else {
			GoToCmd.resetControls(gameControl);
			return true;
		}
	}
	
	private BlockPos getTargetBlockPos(BlockPos bp, int placeDir) {
		if (placeDir == 1) {
			return bp.add(0, 1, 0);
		} else if (placeDir == 0) {
			return bp.add(0, -1, 0);
		} else if (placeDir == 2) {
			return bp.add(0, 0, -1);
		} else if (placeDir == 3) {
			return bp.add(0, 0, 1);
		} else if (placeDir == 4) {
			return bp.add(-1, 0, 0);
		} else if (placeDir == 5) {
			return bp.add(1, 0, 0);
		} else {
			return null;
		}
	}

	private void destoryBlock() {
		gameControl.sendDestoryBlockAt(currTarget, currentRec.facing);
		stepAttempted = true;
	}

	private void buildRecordedStep() {
		gameControl.playerSwingItem();
//		System.out.println("---bp:" + bp);
//		System.out.println("---player:" + player.posX + "," + player.posY + "," + player.posZ);
		gameControl.sendBlockPlacementPacket(currentRec.blockPos.x, currentRec.blockPos.y, currentRec.blockPos.z, 
				currentRec.placeDir);
		stepAttempted = true;
		resetMillis();
	}

}
