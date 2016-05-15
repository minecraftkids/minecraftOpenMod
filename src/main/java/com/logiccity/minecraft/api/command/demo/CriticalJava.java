/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class CriticalJava extends CustomModCommandBase {

	private CriticalJava() {
		super("CriticalJava", "N");
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (this.hasMillisPassed(200)) {
			doCritical();
		}
		return false;
	}

	public void doCritical() {
		if (gameInfo.isSolid(gameInfo.getLivingEntityLocation(null).add(0, -1, 0)) && gameInfo.isPlayerOnGround()) {
			gameControl.setPlayerMotionY(0.1F);
			gameControl.setPlayerFallDistance(0.1F);
			gameControl.setPlayerOnGround(false);
		}
	}
}
