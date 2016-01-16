package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class TallWallSide extends AbstractBuildCommand {
	private static final int[][] building = 
			//Wall in front
		  {  { -1, 1, 2 },{ -2, 1, 2 },{ 0, 1, 2 }, { 1, 1, 2 }, { 2, 1, 2 },  { 3, 1, 2 }, { -3, 1, 2 }, { 4, 1, 2 }, { -4, 1, 2 }, { 5, 1, 2 }, 
			 { -5, 1, 2 }, { -5, 1, 1 }, { -5, 1, 0}, { -5, 1, -1 }, { -5, 1, -2 }, { -5, 1, -3 }, { -5, 1, -4 }, { -5, 1, -5 }, { -5, 1, -6 }, 
			{ 0, 1, -6 }, { 1, 1, -6 }, { -1, 1, -6 }, { 2, 1, -6 },{ -2, 1, -6 },  { -3, 1, -6 }, { 3, 1, -6 }, { -4, 1, -6 }, { 4, 1, -6 }, { -5, 1, -6 }, { 5, 1, -6 },  
	};
	
	private TallWallSide() {
		super("TWSide", building);
	}
}
