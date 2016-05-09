/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class AutoSprint extends CustomModCommandBase {

	private AutoSprint() {
		super("AutoSprint", "S");
	}

	@Override
	public boolean doInUpdateTicThread() {		
		if((! gameInfo.isPlayerCollidedHorizontally())
			&& gameInfo.getPlayerForwardSpeed() > 0
			&& (! gameInfo.isKeySneakPressed())) {
			gameControl.setPlayerSprinting(true);
		}
		return false;
	}
}
