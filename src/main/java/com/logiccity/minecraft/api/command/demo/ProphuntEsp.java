package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class ProphuntEsp extends CustomModCommandBase {
	private ProphuntEsp() {
		super("ProphuntEsp", "K");
	}
	
	@Override
	public boolean doInRenderTicThread() {
		gameControl.renderInvisibleLivingEntities();
		return false;
	}
}
