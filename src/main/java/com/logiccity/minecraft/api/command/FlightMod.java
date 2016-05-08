package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class FlightMod extends CustomModCommandBase {
	private FlightMod() {
		super("Flight", "F");
	}

	private double startY;

	@Override
	public void initCmd(String[] args) {
		double startX = gameInfo.getPlayerPosX();
		startY = gameInfo.getPlayerPosY();
		double startZ = gameInfo.getPlayerPosZ();
		for (int i = 0; i < 4; i++) {
			gameControl.sendPlayerPositionPacketToServer(startX, startY + 1.01, startZ, false);
			gameControl.sendPlayerPositionPacketToServer(startX, startY, startZ, false);
		}
		gameControl.playerJumpOnce();
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (!gameInfo.isPlayerOnGround()) {
			if (gameInfo.isKeyJumpPressed() && gameInfo.getPlayerPosY() < startY - 1) {
				gameControl.setPlayerMotionY(0.2);
			} else {
				gameControl.setPlayerMotionY(-0.02);
			}
		}
		return false;
	}
}
