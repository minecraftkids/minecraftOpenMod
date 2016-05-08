package com.logiccity.minecraft.api.command;

import java.util.ArrayList;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.GameControl;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;
import com.logiccity.minecraft.api.util.PathFinder;
import com.logiccity.minecraft.api.util.PathUtils;

public class GoToCmd extends CustomModCommandBase {
	private BlockCenterFlags blockCenterFlags = new BlockCenterFlags();
	private GoToCmd() {
		super("goto", 3);
	}
	
	private ArrayList<BlockPos> path;
	private int index, yawI;

	private boolean sneaking = false;
	
	@Override
	public void initCmd(String[] args)
	{
		double[] pos = new double[] { Double.parseDouble(args[0]),
				Double.parseDouble(args[1]), Double.parseDouble(args[2]) };
		if (Math.abs(pos[0] - gameInfo.getPlayerPosX()) > 256
				|| Math.abs(pos[2] - gameInfo.getPlayerPosZ()) > 256) {
			gameControl.chatLogError("Goal is out of range! Maximum range is 256 blocks.");
			path = null;
			return;
		}
		index = 0;
		BlockPos goal = new BlockPos(pos[0], pos[1], pos[2]);
		if (PathUtils.isSafe(goal, gameInfo)) {
			PathFinder pathFinder = new PathFinder(gameInfo, goal);
			if (pathFinder.find()) {
				path = pathFinder.formatPath();
				System.out.println("found path: " + path);
				if (path.size() > 0) {
					yawI = Turn.getAxisesYaw(gameInfo.getRotationYaw());
					gameControl.executeCommand("turn", new String [] { String.valueOf(yawI) });
					
					resetControls(gameControl);
					setBlockCenterFlags();
				}
				return;
			}
		}
		path = null;
		gameControl.chatLogError("Could not find a path.");
	}
	
	private void setBlockCenterFlags() {
		double dx = Math.floor(gameInfo.getPlayerPosX()) + 0.5 - gameInfo.getPlayerPosX();
		double dz = Math.floor(gameInfo.getPlayerPosZ()) + 0.5 - gameInfo.getPlayerPosZ();
		if (dx > 0) {
			blockCenterFlags.px = true;
		} else if (dx < 0) {
			blockCenterFlags.nx = true;
		}
		if (dz > 0) {
			blockCenterFlags.pz = true;
		} else if (dz < 0) {
			blockCenterFlags.nz = true;
		}
	}

	@Override
	public void cleanupCmd()
	{
		path = null;
		resetControls(gameControl);
	}

	public static final void resetControls(GameControl gc) {
		gc.releaseForwardKey();
		gc.releaseBackKey();
		gc.releaseRightKey();
		gc.releaseLeftKey();
		gc.releaseJumpKey();
		gc.releaseSneakKey();
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if(path == null || path.isEmpty())
		{
			return true;
		}
		resetControls(gameControl);
		if (gameInfo.isCommandRunning("turn")) {
			return false;
		}
		if (Math.abs(gameInfo.getRotationYaw() - yawI) > 0.1 ) {
			gameControl.executeCommand("turn", new String [] { String.valueOf(yawI) });
			return false;
		}
		BlockPos currentPos = gameInfo.getLivingEntityLocation(null);
		if ((! sneaking) && blockCenterFlags.needCenter()) {
			double dxB = currentPos.getX() + 0.5 - gameInfo.getPlayerPosX(),
					dzB = currentPos.getZ() + 0.5 - gameInfo.getPlayerPosZ();
//System.out.println("---:Loc: (" + player.posX + "," + player.posZ + ")");
//System.out.println("---:Delta: (" + dxB + "," + dzB + ")");

			if(blockCenterFlags.px) {
				if (dxB > 0) {
					movePlayerX(gameControl, true, yawI);
				} else {
					gameControl.clearPlayerMotionXZ();
					blockCenterFlags.px = false;
				}
			} else if (blockCenterFlags.nx) { 
				if(dxB < 0) {
					movePlayerX(gameControl, false, yawI);
				} else {
					gameControl.clearPlayerMotionXZ();
					blockCenterFlags.nx = false;
				}
			}
			if (blockCenterFlags.pz) { 
				if (dzB > 0) {
					movePlayerZ(gameControl, true, yawI);
				} else {
					gameControl.clearPlayerMotionXZ();
					blockCenterFlags.pz = false;
				}
			} else if (blockCenterFlags.nz) { 
				if (dzB < 0) {
					movePlayerZ(gameControl, false, yawI);
				} else {
					gameControl.clearPlayerMotionXZ();
					blockCenterFlags.nz = false;
				}
			}
//			Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = sneaking;
			return false;
		}
		BlockPos nextPos = path.get(index);
		while (gameInfo.isSolid(nextPos)) {
			nextPos = nextPos.add(0, 1, 0);
		}
		sneaking = nextPos.getY() == ((int) Math.floor(gameInfo.getPlayerPosY())) && (! gameInfo.isSolid(nextPos.add(0, -1, 0)));
		if (sneaking) {
			gameControl.pressSneakKey();
		} else {
			gameControl.releaseSneakKey();
		}
		int dx = nextPos.getX() - currentPos.getX(), dy = nextPos.getY() - currentPos.getY(), 
				dz = nextPos.getZ() - currentPos.getZ();
		
//		System.out.println("---currentPos:" + currentPos);
//		System.out.println("---nextPos:" + nextPos);
//		System.out.println("---dx:" + dx + ";dy:" + dy + ";dz:" + dz);
		if (dy > 0) {
			gameControl.pressJumpKey();
//		} else if (dy < 0) {
//			if(PathUtils.isFlyable(currentPos)) {
//				Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
//			}
		}
//		jumpOverObstacle(currentPos, dx, dz);
		if(dx > 0) {
			movePlayerX(gameControl, true, yawI);
		} else if (dx < 0) {
			movePlayerX(gameControl, false, yawI);
		}
		if (dz > 0) {
			movePlayerZ(gameControl, true, yawI);
		} else if (dz < 0) {
			movePlayerZ(gameControl, false, yawI);
		}
		if (dx == 0 && dz == 0) {
			index++;
			resetControls(gameControl);
			if(index >= path.size()) {
				return true;
			}
			setBlockCenterFlags();
			return false;
		}
		return false;
	}
		
	private static class BlockCenterFlags {
		boolean pz = false, nz = false, px = false, nx = false;

		void reset() {
			pz = nz = px = nx = false;
		}

		boolean needCenter() {
			return false; //pz || nz || px || nx;
		}
	}
	
	public static void movePlayerX(GameControl gc, boolean pos, int yawI) {
		if (yawI == 0) {
			if (pos) {
				gc.pressLeftKey();
			} else {
				gc.pressRightKey();
			}
		} else if (yawI == 90) {
			if (pos) {
				gc.pressBackKey();
			} else {
				gc.pressForwardKey();
			}
		} else if (yawI == -90) {
			if (pos) {
				gc.pressForwardKey();
			} else {
				gc.pressBackKey();
			}
		} else {
			if (pos) {
				gc.pressRightKey();
			} else {
				gc.pressLeftKey();
			}
		}
	}
	
	public static void movePlayerZ(GameControl gc, boolean pos, int yawI) {
		if (yawI == 0) {
			if (pos) {
				gc.pressForwardKey();
			} else {
				gc.pressBackKey();
			}
		} else if (yawI == 90) {
			if (pos) {
				gc.pressLeftKey();
			} else {
				gc.pressRightKey();
			}
		} else if (yawI == -90) {
			if (pos) {
				gc.pressRightKey();
			} else {
				gc.pressLeftKey();
			}
		} else {
			if (pos) {
				gc.pressBackKey();
			} else {
				gc.pressForwardKey();
			}
		}
	}
}
