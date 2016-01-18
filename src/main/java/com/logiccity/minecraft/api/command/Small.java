package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class Small extends AbstractBuildCommand {
	private static final int[][] building = 
		  { { 2, 1 , 2 }, { 2, 1, 3 }, { 2, 1, 4 }, { 2, 1, 5 }, { 2, 1, 6 }, 
			{ 1, 1 , 2 }, { 1, 1, 3 }, { 1, 1, 4 }, { 1, 1, 5 }, { 1, 1, 6 }, 
			{ 0, 1 , 2 }, { 0, 1, 3 }, { 0, 1, 4 }, { 0, 1, 5 }, { 0, 1, 6 }, 
			{ -1, 1 , 2 }, { -1, 1, 3 }, { -1, 1, 4 }, { -1, 1, 5 }, { -1,1, 6 }, 
			{ -2, 1 , 2 }, { -2, 1, 3 }, { -2, 1, 4 }, { -2, 1, 5 }, { -2, 1, 6 }, 
			
							{ 1, 2, 3 }, { 1, 2, 4 }, { 1, 2, 5 }, 
							{ 0, 2, 3 }, { 0, 2, 4 }, { 0, 2, 5 },
							{ -1, 2, 3 }, { -1, 2, 4 }, { -1, 2, 5 },
							
							
							              { 0, 3, 4 },
							
			
			
			
	};

	private Small() {
		super("smallpyramidfront", building);
	}
}
