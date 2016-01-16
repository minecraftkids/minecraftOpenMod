package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomCommandBase;


public class BuildRecord extends CustomCommandBase {
	private BuildRecord() {
		super("recordB", 1);
	}
	
	@Override
	public void execute(String[] args) {
		gameControl.recordBuildingSteps(args[0]);
	}
}
