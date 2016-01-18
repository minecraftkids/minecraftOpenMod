package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class BuildWall extends AbstractBuildCommand {
	private static int[][] building = 
		  { { 0, 1, 2 }, { 1, 1, 2 }, { -1, 1, 2 }, { 2, 1, 2 }, { -2, 1, 2 }, 
			{ 0, 2, 2 }, { 1, 2, 2 }, { -1, 2, 2 }, { 2, 2, 2 }, { -2, 2, 2 }, 
			{ 0, 3, 2 }, { 1, 3, 2 }, { -1, 3, 2 }, { 2, 3, 2 }, { -2, 3, 2 }, 
	};
	
	private BuildWall() {
		super("buildWall", building);
	}
}
