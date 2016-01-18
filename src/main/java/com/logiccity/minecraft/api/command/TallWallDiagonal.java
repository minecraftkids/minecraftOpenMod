package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class TallWallDiagonal extends AbstractBuildCommand {
	private static final int[][] building = 
		  { { 0, 1, 0 }, { 1, 1, 1 }, { -1, 1, -1 }, { 2, 1, 2 }, { -2, 1, -2 }, 
			{ 0, 2, 0 }, { 1, 2, 1 }, { -1, 2, -1 }, { 2, 2, 2 }, { -2, 2, -2 }, 
			{ 0, 3, 0 }, { 1, 3, 1 }, { -1, 3, -1 }, { 2, 3, 2 }, { -2, 3, -2 }, 
			{ 0, 4, 0 }, { 1, 4, 1 }, { -1, 4, -1 }, { 2, 4, 2 }, { -2, 4, -2 }, 
			{ 0, 5, 0 }, { 1, 5, 1 }, { -1, 5, -1 }, { 2, 5, 2 }, { -2, 5, -2 }, 
			{ 0, 6, 0 }, { 1, 6, 1 }, { -1, 6, -1 }, { 2, 6, 2 }, { -2, 6, -2 }, 
			{ 0, 7, 0 }, { 1, 7, 1 }, { -1, 7, -1 }, { 2, 7, 2 }, { -2, 7, -2 }, 
		
	};
	
	private TallWallDiagonal() {
		super("TWDiagonal", building);
	}
}
