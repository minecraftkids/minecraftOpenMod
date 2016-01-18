package com.logiccity.minecraft.api.impl;


import com.logiccity.minecraft.api.util.MathUtils;

public abstract class AbstractBuildCommand extends CustomModCommandBase {


	private int[][] building;
	private float yaw;
	private double x, y, z;
	private int idx = 0;

	protected AbstractBuildCommand(String name, int [][] building) {
		super(name, 0, 3);
		this.building = building;
	}

	@Override
	public void initCmd(String[] args) {
		yaw = gameInfo.getRotationYaw();
		yaw = MathUtils.normalYaw(yaw);
		if (args == null || args.length < 3) {
			x = gameInfo.getPlayerPosX();
			y = gameInfo.getPlayerPosY();
			z = gameInfo.getPlayerPosZ();
		} else {
			x = Double.parseDouble(args[0]);
			y = Double.parseDouble(args[1]);
			z = Double.parseDouble(args[2]);
			gameControl.executeCommand("goto", new String[] { args[0], args[1], args[2] });
		}
	}
	
	@Override
	public void cleanupCmd() {
		gameControl.executeCommand("turn", new String [] {String.valueOf(yaw)});
	}
	
	@Override
	public boolean doInUpdateTicThread() {
		if (idx < building.length) {
			int [] buildingI = building[idx ++];
			gameControl.buildOneBlock(buildingI, yaw, x + 1, y, z);
			return false;
		}
		return true;
	}
	
}
