/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Tracer extends CustomModCommandBase {

	private Tracer() {
		super("Tracer", "I");
	}

	@Override
	public boolean doInRenderTicThread() {
		gameControl.renderPlayerTracers();
		return false;
	}
}
