package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Cmd extends CustomModCommandBase {
	private String playerName = "FriendToDino";

	private Cmd() {
		super("cmd");
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (this.hasMillisPassed(500)) {
			String holding = gameInfo.holdingItemTypeName(playerName);
			if (holding != null && holding.indexOf("bow") != -1) {
				float[] delta = gameInfo.lookAtMeDelta(playerName);
				if (delta != null) {
					// System.out.println(delta[0] + "," + delta[1]);
					if (delta[0] < 5 && delta[1] < 1) {
						gameControl.pressLeftKey();
						gameControl.pressSprintKey();
						return false;
					}
				}
				gameControl.releaseLeftKey();
				gameControl.releaseSprintKey();
			}
		}
		return false;
	}
}
