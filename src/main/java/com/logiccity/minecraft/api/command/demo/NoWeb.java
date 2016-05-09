/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class NoWeb extends CustomModCommandBase {

	private NoWeb() {
		super("NoWeb", "J");
	}

	@Override
	public boolean doInUpdateTicThread() {
		gameControl.setPlayerNotInWeb();
		return false;
	}	
}
