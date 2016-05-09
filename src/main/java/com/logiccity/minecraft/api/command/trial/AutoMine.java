/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.trial;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class AutoMine extends CustomModCommandBase {

	private AutoMine() {
		super("autoMine");
	}

	public void initCmd(String[] args) {
		gameControl.pressReleaseAttackKey(false);
	}

	@Override
	public boolean doInUpdateTicThread() {
		BlockPos bp = gameInfo.getMouseOverBlock();
		if (bp == null) {
			return false;
		}
		if (gameInfo.isSolid(bp)) {
			gameControl.pressReleaseAttackKey(true);
		} else {
			gameControl.pressReleaseAttackKey(false);
		}
		return false;
	}

	public void cleanup() {
		gameControl.pressReleaseAttackKey(false);
	}
}
