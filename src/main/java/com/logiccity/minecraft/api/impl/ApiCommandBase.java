package com.logiccity.minecraft.api.impl;

import org.lwjgl.input.Keyboard;

import com.logiccity.minecraft.api.GameControl;
import com.logiccity.minecraft.api.GameInfo;

public abstract class ApiCommandBase {
	private long lastMS;
	protected GameControl gameControl = null;
	protected GameInfo gameInfo = null;
	private int[] argNums;
	private String name;
	private int keyCode = -1;
	private char keyChar = Character.MIN_VALUE;
	protected ApiCommandBase(String name, int... args) {
		this.name = name;
		this.argNums = args;
	}
	
	protected ApiCommandBase(String name, String key, int... args) {
		this(name, args);
		if (key != null && key.length() == 1) {
			key = key.toUpperCase();
			keyCode = Keyboard.getKeyIndex(key);
			keyChar = key.charAt(0);
		}
	}
	
	public String getName() {
		return name;
	}

	public char getKeyChar() {
		return keyChar;
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
	
	public GameControl getGameControl() {
		return gameControl;
	}
	
	public GameInfo getGameInfo() {
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

	public int getKey() {
		return keyCode;
	}
}
