package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.BuildBooleanArray;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BuildMaze extends BuildBooleanArray {

	private int width, length, height = 2;
	
	protected BuildMaze() {
		super("buildMaze", 2, 3);
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
