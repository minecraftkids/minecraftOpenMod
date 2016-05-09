package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class ProphuntEspMod extends CustomModCommandBase {
	private ProphuntEspMod() {
		super("ProphuntEspMod", "V");
	}
	
	@Override
	public boolean doInRenderTicThread() {
		gameControl.renderInvisibleLivingEntities();
		return false;
	}
}
