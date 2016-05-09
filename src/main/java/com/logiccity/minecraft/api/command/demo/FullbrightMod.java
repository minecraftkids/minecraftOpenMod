/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class FullbrightMod extends CustomModCommandBase {

	private FullbrightMod() {
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
}
