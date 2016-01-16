package com.logiccity.minecraft.api;

import java.util.ArrayList;

public interface GameInfo {
	double getPlayerPosX();

	double getPlayerPosY();

	double getPlayerPosZ();

	double getPlayerDistanceSq(double startX, double startY, double startZ);

	float getRotationYaw();
	float getRotationPitch();

	float getPreviousRotationYaw();
	float getPreviousRotationPitch();

	BlockPos getPlayerBlockPos();

	boolean isSolid(BlockPos pos);

	boolean isSafeWalkOn(BlockPos add);

	boolean isLadder(BlockPos pos);

	boolean isModEnabled(String string);

	boolean isCreativeMode();

	boolean isPlayerFlying();

	boolean isInWater(BlockPos pos);

	boolean isCommandRunning(String string);

	ArrayList<BuildStepRecord> loadRecordedBuildingSteps(String fileNameID);

	boolean isPlayerMovementRestricked();
	
}
