package com.logiccity.minecraft.api.command.staging;

import java.util.List;

import com.logiccity.minecraft.api.impl.CustomCommandBase;

public class ListPlayers extends CustomCommandBase {
	private ListPlayers() {
		super("listP", 1);
	}

	@Override
	public void execute(final String[] args) {
		List<String> bp = gameInfo.getClosestEntityNames(Integer.valueOf(args[0]), true);
		if (bp != null) {
			gameControl.chatLogInfo("�a" + bp.toString() +"��");
		} else {
			gameControl.chatLogInfo("�a[��" + "Players not found" + "�a]�f ");
		}
	}
}
