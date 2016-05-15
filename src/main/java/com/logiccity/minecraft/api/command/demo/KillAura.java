/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import java.util.List;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class KillAura extends CustomModCommandBase {

	public int waitMS = 12;
	public float rangeSQ = 18f;

	private KillAura() {
		super("KillAura", "R", 0, 1, 2);
	}
	
	@Override
	public void initCmd(String[] args) {
		if (args != null && args.length > 0) {
			waitMS = Integer.parseInt(args[0]);
			if (args.length > 1) {
				float range = Float.parseFloat(args[1]);
				rangeSQ = range*range;
			}
		}
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		List<String> enl = gameInfo.getClosestEntityNames(1, false);
		if (enl != null && enl.size() > 0) {
			String en = enl.get(0);
			BlockPos bp = gameInfo.getLivingEntityLocation(en);
			if (gameInfo.getPlayerDistanceSq(bp.getX(), bp.getY(), bp.getZ()) <= rangeSQ) {
				if (hasMillisPassed(waitMS)) {
					if (! gameInfo.isCommandRunning("Criticals")) {
						gameControl.executeCommand("Criticals", null);
					}
					gameControl.sendFaceEntityAttackPackets(en);
				}
				return false;
			}
		}
		if (gameInfo.isCommandRunning("Criticals")) {
			gameControl.stopCommand("Criticals");
		}
		return false;
	}
}
