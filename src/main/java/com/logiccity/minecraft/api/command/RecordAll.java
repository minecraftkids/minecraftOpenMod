package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomCommandBase;


public class RecordAll extends CustomCommandBase {
	private RecordAll() {
		super("recordA", 1);
	}
	
	@Override
	public void execute(String[] args) {
		gameControl.recordAllSteps(args[0]);
	}
}
