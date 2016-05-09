package com.logiccity.minecraft.api.command.staging;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.impl.CustomCommandBase;

public class Coords extends CustomCommandBase {
	private Coords() {
		super("coords", 1);
	}

	@Override
	public void execute(final String[] args) {
		BlockPos bp = gameInfo.getLivingEntityLocation(args[0]);
		if (bp != null) {
			gameControl.chatLogInfo("§a" + bp.toString() +"§§");
		} else {
			gameControl.chatLogInfo("§a[§§" + "Player not found" + "§a]§f ");
		}
	}
}
