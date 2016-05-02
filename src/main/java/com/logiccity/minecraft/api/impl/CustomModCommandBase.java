package com.logiccity.minecraft.api.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.logiccity.minecraft.api.ModCommandInterface;

public abstract class CustomModCommandBase extends ApiCommandBase implements ModCommandInterface {
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
	public void addToSyncCmds(String cmdName, String... args) {
		if (args == null) {
			args = new String[0];
		}
		syncCmds.put(cmdName, args);
	}

	public LinkedHashMap<String, String[]> getSyncCmds() {
		return syncCmds;
	}

}
