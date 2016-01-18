package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomCommandBase;


public class BuildStopRecord extends CustomCommandBase {
	private BuildStopRecord() {
		super("stopR");
	}

	@Override
	public void execute(String[] args) {
		gameControl.stopRecordSteps();
	}
}
