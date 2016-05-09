package com.logiccity.minecraft.api.command.trial;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class TallWall extends AbstractBuildCommand {
	private static final int[][] building = 
		  { { 0, 1, 2 }, { 1, 1, 2 }, { -1, 1, 2 }, { 2, 1, 2 }, { -2, 1, 2 }, 
			{ 0, 2, 2 }, { 1, 2, 2 }, { -1, 2, 2 }, { 2, 2, 2 }, { -2, 2, 2 }, 
			{ 0, 3, 2 }, { 1, 3, 2 }, { -1, 3, 2 }, { 2, 3, 2 }, { -2, 3, 2 }, 
			{ 0, 4, 2 }, { 1, 4, 2 }, { -1, 4, 2 }, { 2, 4, 2 }, { -2, 4, 2 }, 
			{ 0, 5, 2 }, { 1, 5, 2 }, { -1, 5, 2 }, { 2, 5, 2 }, { -2, 5, 2 }, 
			{ 0, 6, 2 }, { 1, 6, 2 }, { -1, 6, 2 }, { 2, 6, 2 }, { -2, 6, 2 }, 
			{ 0, 7, 2 }, { 1, 7, 2 }, { -1, 7, 2 }, { 2, 7, 2 }, { -2, 7, 2 }, 
		
	};
	private TallWall() {
		super("TWall", building);
	}
}
