package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class ProphuntEsp extends CustomModCommandBase {
	private ProphuntEsp() {
		super("ProphuntEspMod", "V");
	}
	
	@Override
	public boolean doInRenderTicThread() {
		gameControl.renderInvisibleLivingEntities();
		return false;
	}
}
