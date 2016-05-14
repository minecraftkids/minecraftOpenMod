package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Flight extends CustomModCommandBase {
	private Flight() {
		super("Flight", "F");
	}

	@Override
	public void initCmd(String[] args) {
		gameControl.executeCommand("NoFall", null);
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if (!gameInfo.isPlayerOnGround()) {
			if (gameInfo.isKeyJumpPressed()) {
				gameControl.setPlayerMotionY(0.2);
			} else if (gameInfo.isKeySneakPressed()){
				gameControl.setPlayerMotionY(-0.2);
			} else {
				gameControl.setPlayerMotionY(-0.02);
			}
		}
		return false;
	}
}
