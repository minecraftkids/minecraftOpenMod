package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.AbstractBuildCommand;

public class SmallTriangle extends AbstractBuildCommand {
	private static final int[][] building = 
		  { { 2, 3 , -2 }, { 2, 3, -1 }, { 2, 3, 0 }, { 2, 3, 1 }, { 2, 3, 2 }, 
			{ 1, 3 , -2 }, { 1, 3, -1 }, { 1, 3, 0 }, { 1, 3, 1 }, { 1, 3, 2 }, 
			{ 0, 3 , -2 }, { 0, 3, -1 }, { 0, 3, 0 }, { 0, 3, 1 }, { 0, 3, 2 }, 
			{ -1, 3 , -2 }, { -1, 3, -1 }, { -1, 3, 0 }, { -1, 3, 1 }, { -1,3, 2 }, 
			{ -2, 3 , -2 }, { -2, 3, -1 }, { -2, 3, 0 }, { -2, 3, 1 }, { -2, 3, 2 }, 
			
							{ 1, 4, -1 }, { 1, 4, 0 }, { 1, 4, 1 }, 
							{ 0, 4, -1 }, { 0, 4, 0 }, { 0, 4, 1 },
							{ -1, 4, -1 }, { -1, 4, 0 }, { -1, 4, 1 },
							
							
							              { 0, 5, 0 },
							
			
			
			
	};
	private SmallTriangle() {
		super("smallpyramidup", building);
	}
}
