package com.logiccity.minecraft.api.command.trial;

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
