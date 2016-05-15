package com.logiccity.minecraft.api.command.demo;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BaseFinder extends CustomModCommandBase {
	private BaseFinder() {
		super("BaseFinder", "H", 0, 1, 2);
	}
	
	@Override
	public void initCmd(String[] args) {
		if (args != null && args.length > 0) {
			int maxBlocks = Integer.parseInt(args[0]);
			if (args.length > 1) {
				gameControl.initBaseFinder(maxBlocks, Integer.parseInt(args[1]));
			} else {
				gameControl.initBaseFinder(maxBlocks, 50);
			}
		}
	}
	
	@Override
	public boolean doInRenderTicThread() {
		gameControl.baseFinderRender();
		return false;
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (this.hasMillisPassed(3000)) {
			gameControl.baseFinderUpdate();
		}
		return false;
	}
}
