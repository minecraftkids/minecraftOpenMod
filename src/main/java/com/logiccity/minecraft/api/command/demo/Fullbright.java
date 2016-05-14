/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Fullbright extends CustomModCommandBase {

	private Fullbright() {
		super("Fullbright", "B");
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		float brightness = gameInfo.getWorldBrightness();
		if (brightness < 16F) {
			gameControl.setWorldBrightness(brightness + 0.5f);
		}
		return false;
	}
	
	@Override
	public void cleanupCmd() {
		gameControl.setWorldBrightness(0);
	}
}
