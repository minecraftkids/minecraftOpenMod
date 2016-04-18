package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.BuildBooleanArray;

public class BuildMaze extends BuildBooleanArray {

	private int width, length;
	
	protected BuildMaze() {
		super("buildMaze", 2, 3);
	}
	protected BuildMaze(String cheatName) {
		super(true, cheatName, 2, 3);
	}
	@Override
	public void initCmd(String [] args) {
		width = Integer.parseInt(args[0]);
		length = Integer.parseInt(args[1]);
		if (args.length > 2) {
			height = Integer.parseInt(args[2]);
		}
		maze = gameInfo.generateMaze(width, length);
		startBp = gameInfo.getPlayerBlockPos().add(0, 0, 3);
		super.initCmd(args);
	}
}
