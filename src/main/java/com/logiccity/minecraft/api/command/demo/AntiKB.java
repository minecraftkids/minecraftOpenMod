/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */

package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class AntiKB extends CustomModCommandBase {

	private AntiKB() {
		super("AntiKB", "Z");
	}
	
	@Override
	public void initCmd(String[] args) {
		gameControl.setPlayerKnockBackEnabled(false);
	}

	@Override
	public void cleanupCmd() {
		gameControl.setPlayerKnockBackEnabled(true);
	}
}
