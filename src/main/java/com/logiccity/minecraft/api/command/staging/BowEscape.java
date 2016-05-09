package com.logiccity.minecraft.api.command.staging;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BowEscape extends CustomModCommandBase {
	private String playerName;

	private BowEscape() {
		super("bowEscape", 1);
	}
	
	@Override
	public void initCmd(String [] args) {
		playerName = args[0];
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (this.hasMillisPassed(500)) {
			if ("bow".equals(gameInfo.holdingItemUnlocalizedName(playerName))) {
				float[] delta = gameInfo.lookAtMeDelta(playerName);
				if (delta != null) {
					// System.out.println(delta[0] + "," + delta[1]);
					if (delta[0] < 5 && delta[1] < 1) {
						gameControl.pressReleaseLeftKey(true);
						gameControl.pressReleaseSprintKey(true);
						return false;
					}
				}
				gameControl.pressReleaseLeftKey(false);
				gameControl.pressReleaseSprintKey(false);
			}
		}
		return false;
	}
	
	@Override
	public void cleanupCmd() {
		gameControl.pressReleaseLeftKey(false);
		gameControl.pressReleaseSprintKey(false);
	}

}
