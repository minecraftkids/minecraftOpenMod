/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Criticals extends CustomModCommandBase {

	private Criticals() {
		super("Critical", "N");
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (gameInfo.isKeyAttackPressed()) {
			doCritical();
		}
		return false;
	}

	public void doCritical() {
		if (gameInfo.isSolid(gameInfo.getLivingEntityLocation(null).add(0, -1, 0)) && gameInfo.isPlayerOnGround()) {
			double posX = gameInfo.getPlayerPosX();
			double posY = gameInfo.getPlayerPosY();
			double posZ = gameInfo.getPlayerPosZ();
			gameControl.sendPlayerPositionPacketToServer(posX, posY + 0.0625D, posZ, true);
			gameControl.sendPlayerPositionPacketToServer(posX, posY, posZ, false);
			gameControl.sendPlayerPositionPacketToServer(posX, posY + 1.1E-5D, posZ, false);
			gameControl.sendPlayerPositionPacketToServer(posX, posY, posZ, false);

		}
	}
}
