/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class NoFall extends CustomModCommandBase {

	private NoFall() {
		super("NoFall", "L");
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		gameControl.sendFakeOnGroundPackageIfFalling();
		return false;
	}
}
