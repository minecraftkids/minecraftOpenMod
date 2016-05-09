/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Xray extends CustomModCommandBase {

	private Xray() {
		super("Xray", "X");
	}

	@Override
	public void initCmd(String[] args) {
		gameControl.refreshRenderers();
	}

	@Override
	public void cleanupCmd() {
		gameControl.refreshRenderers();
	}
}
