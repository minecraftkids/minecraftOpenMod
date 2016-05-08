package com.logiccity.minecraft.api.command;

import java.util.List;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class Attack extends CustomModCommandBase {
	private static final int CLOSE_CNT = 5;
	private String chosenName = null;
	List<String> closeEntityNames = null;
	private Attack() {
		super("attack");
	}
	
	@Override
	public void initCmd(String [] args) {
		chosenName = null;
		closeEntityNames = gameInfo.getClosestEntityNames(CLOSE_CNT, false);
		String msg = "Choose target: ";
		int i = 1;
		for (String name : closeEntityNames) {
			msg += (i ++) + "(" + name + "), ";
		}
		gameControl.chatLogInfo(msg);
	}
	@Override
	public void cleanupCmd() {
		gameControl.releaseForwardKey();
	}

	@Override
	protected boolean handleCmdInput(String input) {
		try {
			int index = Integer.parseInt(input) - 1;
			if (index > -1 && index < CLOSE_CNT) {
				chosenName = closeEntityNames.get(index);
			}
		} catch (Exception e) {
			// ignore error inputs
		}
		if (chosenName == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if (chosenName == null) {
			return false;
		}
		return gameControl.marchAttackEntity(chosenName, 200);
	}

}
