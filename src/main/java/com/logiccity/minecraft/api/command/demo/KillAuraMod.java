/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import java.util.List;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class KillAuraMod extends CustomModCommandBase {

	public int realSpeed = 12;
	public float realRange = 20F;

	private KillAuraMod() {
		super("KillAura", "R");
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		List<String> enl = gameInfo.getClosestEntityNames(1, true);
		if (enl != null && enl.size() > 0) {
			String en = enl.get(0);
			BlockPos bp = gameInfo.getLivingEntityLocation(en);
			if (gameInfo.getPlayerDistanceSq(bp.getX(), bp.getY(), bp.getZ()) <= realRange
				&& hasMillisPassed(realSpeed)) {
				gameControl.executeCommandMethod("Critical", "doCritical");
				gameControl.sendFaceEntityAttackPackets(en);
			}
		}
		return false;
	}
}
