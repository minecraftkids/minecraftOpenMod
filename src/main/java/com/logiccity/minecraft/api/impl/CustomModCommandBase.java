package com.logiccity.minecraft.api.impl;

import com.logiccity.minecraft.api.CommandState;
import com.logiccity.minecraft.api.ModCommandInterface;

public abstract class CustomModCommandBase extends ApiCommandBase implements ModCommandInterface {
	protected CustomModCommandBase(String name, int... args) {
		super(name, args);
	}

	protected CommandState commandState;
	
	public void setCommandState(CommandState commandState) {
		this.commandState = commandState;
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

}
