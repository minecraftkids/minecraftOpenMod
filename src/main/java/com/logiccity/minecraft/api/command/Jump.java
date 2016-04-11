package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomCommandBase;

public class Jump extends CustomCommandBase {
	private Jump() {
		super("jump");
	}

	@Override
	public void execute(final String[] args) {
		gameControl.playerJumpOnce();
	}
}
