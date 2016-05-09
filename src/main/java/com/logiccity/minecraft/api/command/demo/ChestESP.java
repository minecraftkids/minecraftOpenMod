/*
 * Copyright © 2015 modByKids contributors
 * All rights reserved.
 */
package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class ChestESP extends CustomModCommandBase {

	private ChestESP() {
		super("ChestESP", "P");
	}

	private int maxChests = 1000;
	public boolean shouldInform = true;

	@Override
	public void initCmd(String[] args) {
		shouldInform = true;
		if (args != null && args.length > 0) {
			maxChests = Integer.parseInt(args[0]);
		}
	}

	@Override
	public boolean doInRenderTicThread() {
		int i = 0;
		boolean maxed = gameControl.renderChestEsp(maxChests);
		if (maxed && shouldInform) {
			gameControl.chatLogWarning(getName()
					+ " found §lA LOT§r of chests.");
			gameControl.chatLogInfo("To prevent lag, it will only show the first "
							+ maxChests + " chests.");
			shouldInform = false;
		} else if (! maxed) {
			shouldInform = true;
		}
		return  false;
	}
}
