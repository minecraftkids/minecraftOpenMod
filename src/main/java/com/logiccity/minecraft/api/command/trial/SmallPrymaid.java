package com.logiccity.minecraft.api.command.trial;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class SmallPrymaid extends AbstractBuildCommand {
	private static final int[][] building = 
		  { { 2, -2 , -2 }, { 2, -2, -1 }, { 2, -2, 0 }, { 2, -2, 1 }, { 2, -2, 2 }, 
			{ 1, -2 , -2 }, { 1, -2, -1 }, { 1, -2, 0 }, { 1, -2, 1 }, { 1, -2, 2 }, 
			{ 0, -2 , -2 }, { 0, -2, -1 }, { 0, -2, 0 }, { 0, -2, 1 }, { 0, -2, 2 }, 
			{ -1, -2 , -2 }, { -1, -2, -1 }, { -1, -2, 0 }, { -1, -2, 1 }, { -1,-2, 2 }, 
			{ -2, -2 , -2 }, { -2,-2, -1 }, { -2, -2, 0 }, { -2, -2, 1 }, { -2, -2, 2 }, 
			
							{ 1, -1, -1 }, { 1, -1, 0 }, { 1, -1, 1 }, 
							{ 0, -1, -1 }, { 0, -1, 0 }, { 0, -1, 1 },
							{ -1, -1, -1 }, { -1, -1, 0 }, { -1, -1, 1 },
							
							
							              { 0, 0, 0 },
							
			
			
			
	};
	private SmallPrymaid() {
		super("smallpyramiddown", building);
	}
}
