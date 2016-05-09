package com.logiccity.minecraft.api.command.trial;

import com.logiccity.minecraft.api.impl.CustomCommandBase;

public class TpCmd extends CustomCommandBase {
	private TpCmd() {
		super("tpo",3);
	}

	@Override
	public void execute(final String[] args) {
		double x = Double.valueOf(args[0]);
		double y = Double.valueOf(args[1]);
		double z = Double.valueOf(args[2]);
		gameControl.setPlayerLocation(x,y,z);
	}
}
