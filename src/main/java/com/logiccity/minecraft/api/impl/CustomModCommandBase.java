package com.logiccity.minecraft.api.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;

import com.logiccity.minecraft.api.ModCommandInterface;

public class CustomModCommandBase extends ApiCommandBase implements ModCommandInterface {
	protected CustomModCommandBase(String name, int... args) {
		super(name, args);
	}

	protected CustomModCommandBase(String name, String key, int... args) {
		super(name, key, args);
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
	public boolean doInUpdateTicThread() {
		return false;
	}

	@Override
	public boolean doInPostInGameRenderTicThread() {
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
	
	private final LinkedHashMap<String, String[]> syncCmds = new LinkedHashMap<String, String[]>();
	
	@Override
	public void addToSyncCmds(String cmdName, String argStr) {
		String [] args;
		if (argStr == null || (argStr = argStr.trim()).length() == 0) {
			args = new String[0];
		} else {
			args = argStr.split("[ ,]+");
		}
		syncCmds.put(cmdName, args);
	}

	public LinkedHashMap<String, String[]> getSyncCmds() {
		return syncCmds;
	}
}
