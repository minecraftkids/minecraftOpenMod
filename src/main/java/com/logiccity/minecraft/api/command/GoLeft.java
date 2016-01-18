package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class GoLeft extends CustomModCommandBase {
	private GoLeft() {
		super("goL", 1);
	}
	
	double dist , startX, startY, startZ;
	
	@Override
	public void initCmd(String [] args) {
		dist = Double.parseDouble(args[0]);
		startX = gameInfo.getPlayerPosX();
		startY = gameInfo.getPlayerPosY();
		startZ = gameInfo.getPlayerPosZ();
		dist = dist * dist;
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if (gameInfo.getPlayerDistanceSq(startX,
				startY, startZ) < dist) {
			gameControl.pressLeftKey();
			return false;
		}
		gameControl.releaseLeftKey();
		return true;
	}

}
