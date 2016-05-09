/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.demo;

import java.util.Random;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class AntiAFK extends CustomModCommandBase {
	private BlockPos block;
	private Random random;
	private BlockPos nextBlock;

	private AntiAFK() {
		super("AntiAFK", "M");
	}
	
	@Override
	public void initCmd(String [] args) {
		try
		{
			block = gameInfo.getLivingEntityLocation(null);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		random = new Random();
	}
	
	
	@Override
	public boolean doInUpdateTicThread() {		
		if(this.hasMillisPassed(3000) || nextBlock == null)
		{
			nextBlock =
				block.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
		}
		float yaw = gameInfo.faceBlockYaw(nextBlock);
		if (Math.abs(yaw - gameInfo.getRotationYaw()) > 0.1) {
			addToSyncCmds("turn", String.valueOf(yaw));
		}
		if(gameInfo.getPlayerDistanceSq(nextBlock.getX(), nextBlock.getY(), nextBlock.getZ()) > 1)
			gameControl.pressReleaseForwardKey(true);
		else
			gameControl.pressReleaseForwardKey(false);
		return false;
	}

	@Override
	public void cleanupCmd() {
		gameControl.pressReleaseForwardKey(false);
	}
}
