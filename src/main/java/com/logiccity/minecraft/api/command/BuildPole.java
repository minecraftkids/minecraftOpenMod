package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BuildPole extends CustomModCommandBase {
	private BlockPos bp;
	
	private BuildPole() {
		super("pole");
	}
	
	@Override
	public void initCmd(String [] args) {
		bp = gameInfo.getLivingEntityLocation(null);
		gameControl.setRotationPitch(90);
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		gameControl.pressJumpKey();
		if ( gameInfo.getPlayerPosY() > bp.getY() + 1) {
			gameControl.sendBlockPlacementPacket(bp.getX(), bp.getY() - 1, bp.getZ(), 1);
			gameControl.releaseJumpKey();
			return true;
		}
		return false;
	}


}
