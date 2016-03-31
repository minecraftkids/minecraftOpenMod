package com.logiccity.minecraft.api.impl;

import com.logiccity.minecraft.api.BlockPos;

public class BuildBooleanArray extends CustomModCommandBase {
	protected BuildBooleanArray(String name, int... args) {
		super(name, args);
	}
	private int width, length, height = 2, cx = -1, cz = 0;
	protected boolean[][] maze;
	private BlockPos cBP = null;
	protected BlockPos startBp;
	@Override
	public void initCmd(String [] args) {
		gameControl.executeCommand("turn", new String[] {"0", "0"});
		width = maze.length;
		length = maze[0].length;
		while(! checkBp(startBp)) {
			startBp = startBp.add(1, 0, 0);
		}
		cBP = null;
	}
	
	private boolean checkBp(BlockPos bp1) {
		BlockPos bp2 = bp1.add(-width, 0, 0), bp3 = bp2.add(0, 0, -length-3),
				bp4 = bp1.add(0, 0, -length-3);
		BlockPos bp = bp1;
		while (bp.getZ() >= bp4.getZ()) {
			while (bp.getX() >= bp2.getX()) {
				if (gameInfo.isSolid(bp) || (! gameInfo.isSolid(bp.add(0, -1, 0)))) {
					return false;
				}
				bp = bp.add(-1, 0, 0);
			}
			bp = bp.add(0,  0, -1);
		}
		return true;
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if (gameInfo.isCommandRunning("goto") || gameInfo.isCommandRunning("turn")) {
			return false;
		}
		if (cBP == null || gameInfo.isSolid(cBP)) {
			if (cx == width -1) {
				cx = 0;
				cz ++;
			} else {
				cx ++;
			}
			if (cz == length) {
				return true;
			}
			cBP = startBp.add(-cx, 0, -cz);
		} else if (cBP != null) {
			BlockPos playerBP = gameInfo.getPlayerBlockPos();
			if (Math.abs(playerBP.getX() -cBP.getX()) > 3 || cBP.getZ() - playerBP.getZ() < 2) {
				gameControl.executeCommand("goto", new String[] {String.valueOf(cBP.getX()), 
						String.valueOf(cBP.getY()), String.valueOf(cBP.getZ()-3)});
				return false;
			}
		}
		if (maze[cx][cz]) {
			gameControl.playerSwingItem();
			gameControl.sendBlockPlacementPacket(cBP.getX(), cBP.getY()-1, cBP.getZ(), 
					1, 0, 0, 0);
			System.out.println(cBP);
		} else {
			cBP = null;
		}
		return false;
	}

}
