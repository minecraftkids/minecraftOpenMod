package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class ArmorStatus extends CustomModCommandBase {
	private ArmorStatus() {
		super("ArmorStatus", 0, 1, 2, 3, 4);
	}
	
	@Override
	public void initCmd(String[] args) {
		String listMode = "horizontal", alignMode = "bottomleft";
		boolean showPercent = false, showMaxDamage = true;
		if (args.length > 0) {
			listMode = args[0];
			if (args.length > 1) {
				alignMode = args[1];
				if (args.length > 2) {
					showPercent = Boolean.valueOf(args[2]);
					if (args.length > 3) {
						showMaxDamage = Boolean.valueOf(args[3]);
					}
				}
			}
		}
		gameControl.initArmorStatusUI(listMode, alignMode, showPercent, showMaxDamage);
	}

	@Override
	public boolean doInPostInGameRenderTicThread() {
		gameControl.renderPlayerArmorStatus();
		return false;
	}
}
