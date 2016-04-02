package com.logiccity.minecraft.api.impl;

import com.logiccity.minecraft.api.ModCommandInterface;

public abstract class CustomModCommandBase extends ApiCommandBase implements ModCommandInterface {
	protected CustomModCommandBase(String name, int... args) {
		super(name, args);
	}

	@Override
	public void initCmd(String[] args) {
	}

	@Override
	public void cleanupCmd() {
	}

	@Override
	public boolean doInRenderTicThread() {
		return false;
	}

	@Override
	public boolean doInCmdInputThread(String input) {
		if ("stop".equals(input)) {
			return true;
		}
		return handleCmdInput(input);
	}

	protected boolean handleCmdInput(String input) {
		return false;
	}
}
