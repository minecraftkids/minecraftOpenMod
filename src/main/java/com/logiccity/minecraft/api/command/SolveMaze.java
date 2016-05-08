package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class SolveMaze extends CustomModCommandBase {
	private BlockPos startPos;

	private double checkX, checkZ;

	private SolveMaze() {
		super("solveMaze");
	}

	private static final int FR = 0, FL = 1, BL = 2, BR = 3;
	private int state;

	@Override
	public void initCmd(String[] args) {
		startPos = gameInfo.getLivingEntityLocation(null);
		gameControl.pressRightKey();
		gameControl.pressForwardKey();
		checkX = gameInfo.getPlayerPosX();
		state = FR;
		gameControl.executeCommand("turn", new String[] {"0"});
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (gameInfo.isCommandRunning("turn")) {
			return false;
		}
		BlockPos bp = gameInfo.getLivingEntityLocation(null);
		BlockPos bp1 = bp.add(1, 0, 0);
		BlockPos bp2 = bp.add(-1, 0, 0);
		BlockPos bp3 = bp.add(0, 0, 1);
		BlockPos bp4 = bp.add(0, 0, -1);
		if ((bp != startPos) && (!(gameInfo.isSolid(bp1))) && (!(gameInfo.isSolid(bp2))) && (!(gameInfo.isSolid(bp3)))
				&& (!(gameInfo.isSolid(bp4)))) {
			gameControl.releaseForwardKey();
			gameControl.releaseBackKey();
			gameControl.releaseRightKey();
			gameControl.releaseLeftKey();
			return true;

		}

		if (gameInfo.isPlayerChaningLocation()) {
			if (state == FR) {
				if (checkX - gameInfo.getPlayerPosX() > 1) {
					state = BR;
					gameControl.releaseForwardKey();
					gameControl.pressBackKey();
					checkZ = gameInfo.getPlayerPosZ();
				}
			} else if (state == FL) {
				if (checkZ - gameInfo.getPlayerPosZ() < -1) {
					state = FR;
					gameControl.releaseLeftKey();
					gameControl.pressRightKey();
					checkX = gameInfo.getPlayerPosX();
				}
			} else if (state == BR) {
				if (checkZ - gameInfo.getPlayerPosZ() > 1) {
					state = BL;
					gameControl.releaseRightKey();
					gameControl.pressLeftKey();
					checkX = gameInfo.getPlayerPosX();
				}
			} else if (state == BL) {
				if (checkX - gameInfo.getPlayerPosX() < -1) {
					state = FL;
					gameControl.pressForwardKey();
					gameControl.releaseBackKey();
					checkZ = gameInfo.getPlayerPosZ();
				}
			}
//			if (oldS != state) {
//				System.out.println("Moving switch: from " + oldS + " to " + state);
//			}
			return false;
		}
		if (state == FR) {
			state = FL;
			gameControl.releaseRightKey();
			gameControl.pressLeftKey();
			checkZ = gameInfo.getPlayerPosZ();
		} else if (state == BL) {
			state = BR;
			gameControl.pressRightKey();
			gameControl.releaseLeftKey();
			checkZ = gameInfo.getPlayerPosZ();
		} else if (state == FL) {
			state = BL;
			gameControl.releaseForwardKey();
			gameControl.pressBackKey();
			checkX = gameInfo.getPlayerPosX();
		} else {
			state = FR;
			gameControl.pressForwardKey();
			gameControl.releaseBackKey();
			checkX = gameInfo.getPlayerPosX();
		}
//		if (oldS != state) {
//			System.out.println("blocking switch: from " + oldS + " to " + state);
//		}
		return false;
	}

}
