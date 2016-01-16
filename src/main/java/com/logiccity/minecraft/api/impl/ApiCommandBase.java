package com.logiccity.minecraft.api.impl;

import com.logiccity.minecraft.api.GameControl;
import com.logiccity.minecraft.api.GameInfo;

public abstract class ApiCommandBase {
	private long lastMS;
	protected static GameControl gameControl = null;
	protected static GameInfo gameInfo = null;
	private int[] argNums;
	private String name;
	
	protected ApiCommandBase(String name, int... args) {
		this.name = name;
		this.argNums = args;
	}
	
	public String getName() {
		return name;
	}

	public int[] argNums() {
		return argNums;
	}
	
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	
	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}
	
	public static GameControl getGameControl() {
		return gameControl;
	}
	
	public static GameInfo getGameInfo() {
		return gameInfo;
	}
	
	public boolean hasMillisPassed(long delta) {
		long cms = System.currentTimeMillis();
		boolean passed = cms > lastMS + delta;
		if (passed) {
			lastMS = cms;
		}
		return passed;
	}
	
	public void resetMillis() {
		lastMS = System.currentTimeMillis();
	}
}
