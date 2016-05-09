package com.logiccity.minecraft.api.command.trial;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class AutoStaircase extends AbstractBuildCommand {
	private static int[][] building = 
		  { { 0, 1, 1 }, { 1, 1, 1 }, { -1, 1, 1 },  
			{ 0, 2, 2 }, { 1, 2, 2 }, { -1, 2, 2 }, 
			{ 0, 3, 3 }, { 1, 3, 3 }, { -1, 3, 3 }, 
			{ 0, 4, 4 }, { 1, 4, 4 }, { -1, 4, 4 },
			{ 0, 5, 5 }, { 1, 5, 5 }, { -1, 5, 5 },
	};

	private AutoStaircase() {
		super("staircase", building);
	}
}
