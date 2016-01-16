package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class GoRight extends CustomModCommandBase {
	private GoRight() {
		super("goR", 1);
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
			gameControl.pressRightKey();
			return false;
		}
		gameControl.releaseRightKey();
		return true;
	}

}
