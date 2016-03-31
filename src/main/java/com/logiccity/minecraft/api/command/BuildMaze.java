package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BuildMaze extends CustomModCommandBase {

	protected BuildMaze() {
		super("buildMaze", 2, 3);
	}
	
	private int width, length, height = 2, cx = 0, cz = 0;
	private boolean[][] maze;
	private BlockPos startBp, cBP = null;
	@Override
	public void initCmd(String [] args) {
		gameControl.executeCommand("turn", new String[] {"0", "0"});
		width = Integer.parseInt(args[0]);
		length = Integer.parseInt(args[1]);
		if (args.length > 2) {
			height = Integer.parseInt(args[2]);
		}
		maze = gameInfo.generateMaze(width, length);
		width = maze.length;
		length = maze[0].length;
		startBp = gameInfo.getPlayerBlockPos().add(0, 0, 3);
		while(! checkBp(startBp)) {
			startBp = startBp.add(1, 0, 0);
		}
		cx = cz = 0;
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

	public static void main(String [] argv) {
		System.out.println("  package sldkjfls  ;hgfhjf\r\nlasdjlf\nlsadkjf\r"
				.replaceFirst("[\r|\n]|^\\s*package\\s.*;", System.lineSeparator())
				.replaceFirst("\\*/\\s*package\\s.*;", "*/")); 
	}
}
