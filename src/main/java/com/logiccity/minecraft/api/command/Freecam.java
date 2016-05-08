/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Freecam extends CustomModCommandBase {

	private double oldX;
	private double oldY;
	private double oldZ;

	private Freecam() {
		super("Freecam", "U");
	}

	@Override
	public void initCmd(String[] args) {
		oldX = gameInfo.getPlayerPosX();
		oldY = gameInfo.getPlayerPosY();
		oldZ = gameInfo.getPlayerPosZ();
		gameControl.cloneFakePlayer(-69);
	}

	@Override
	public boolean doInUpdateTicThread() {
		gameControl.clearPlayerMotionXZ();
		gameControl.setPlayerMotionY(0);
		gameControl.setJumpMovementFactor(0.1f);
		if (gameInfo.isKeyJumpPressed()) {
			gameControl.setPlayerMotionY(gameInfo.getPlayerMotionY() + 1);
		}
		if (gameInfo.isKeySneakPressed()) {
			gameControl.setPlayerMotionY(gameInfo.getPlayerMotionY() - 1);
		}
		return false;
	}

	@Override
	public void cleanupCmd() {
		gameControl.setPlayerLocation(oldX, oldY, oldZ);
		gameControl.removeEntityAndRenderWorld(-69);
	}
}
