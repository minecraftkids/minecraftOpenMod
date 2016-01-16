package com.logiccity.minecraft.api;

public interface GameControl {
	void pressForwardKey();
	void releaseForwardKey();
	void pressBackKey();
	void releaseBackKey();
	void pressLeftKey();
	void releaseLeftKey();
	void pressRightKey();
	void releaseRightKey();
	void releaseJumpKey();
	void releaseSneakKey();
	void pressJumpKey();
	void pressSneakKey();
	
	void setRotationPitch(float pitch);
	void setRotationYaw(float yaw);
	
	void chatLogError(String msg);
	void chatLogInfo(String msg);
	void executeCommand(String name, String[] args);
	void clearPlayerMotionXZ();
	
	void recordBuildingSteps(String string);
	void stopRecordSteps();
	void playerSwingItem();
	void sendBlockPlacementPacket(int x, int y, int z, int placeDir, float dx,
			float dy, float dz);
	void sendDestoryBlockAt(BlockPos currTarget, int facing);
	boolean setPlayerCurrentItem(int currentItem);
	
	void buildOneRow(int[] buildingI, float yaw, double x, double y, double z);
	void playerJumpOnce();
}
