/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import java.util.List;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class KillAura extends CustomModCommandBase {

	public int speed = 12;
	public float range = 20F;

	private KillAura() {
		super("KillAura", "R");
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		List<String> enl = gameInfo.getClosestEntityNames(1, true);
		if (enl != null && enl.size() > 0) {
			String en = enl.get(0);
			BlockPos bp = gameInfo.getLivingEntityLocation(en);
			if (gameInfo.getPlayerDistanceSq(bp.getX(), bp.getY(), bp.getZ()) <= range
				&& hasMillisPassed(speed)) {
				gameControl.executeCommandMethod("CriticalJava", "doCritical");
				gameControl.sendFaceEntityAttackPackets(en);
			}
		}
		return false;
	}
}
