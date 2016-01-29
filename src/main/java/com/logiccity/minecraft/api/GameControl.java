package com.logiccity.minecraft.api;

/**
 * The interface for controlling the player or game states
 * 
 * @author Minecraftkids
 *
 */
public interface GameControl {
	/**
	 * Press the forward key
	 */
	void pressForwardKey();
	/**
	 * Release the forward key
	 */
	void releaseForwardKey();
	/**
	 * Press the backward key
	 */
	void pressBackKey();
	/**
	 * Release the backward key
	 */
	void releaseBackKey();
	/**
	 * Press the left key
	 */
	void pressLeftKey();
	/**
	 * Release the left key
	 */
	void releaseLeftKey();
	/**
	 * Press the right key
	 */
	void pressRightKey();
	/**
	 * Release the right key
	 */
	void releaseRightKey();
	/**
	 * Press the jump key
	 */
	void pressJumpKey();
	/**
	 * Release the jump key
	 */
	void releaseJumpKey();
	/**
	 * Press the sneak key
	 */
	void pressSneakKey();
	/**
	 * Release the sneak key
	 */
	void releaseSneakKey();
	
	/**
	 * Set the player's rotation pitch to a new value
	 * @param pitch pitch
	 */
	void setRotationPitch(float pitch);
	/**
	 * Set the player's rotation yaw to a new value
	 * @param yaw yaw
	 */
	void setRotationYaw(float yaw);
	
	/**
	 * Send error level message to the chat log
	 * @param msg error message
	 */
	void chatLogError(String msg);
	/**
	 * Send info level message to the chat log
	 * @param msg info message
	 */
	void chatLogInfo(String msg);
	
	/**
	 * Execute a command
	 * @param name the command name
	 * @param args arguments to the command
	 */
	void executeCommand(String name, String[] args);
	
	/**
	 * Make the player jump once
	 */
	void playerJumpOnce();
	/**
	 * Clear player's XZ momentum so it will stop moving
	 */
	void clearPlayerMotionXZ();
	/**
	 * Make the player swing current holding item
	 */
	void playerSwingItem();
	
	/**
	 * Start to record player's block placements/destructions 
	 * @param name the name used to identify the recorded building steps
	 */
	void recordBuildingSteps(String name);
	/**
	 * Stop the current recording
	 */
	void stopRecordSteps();
	/**
	 * Send block placement packet to the server
	 * @param x the x of the block being clicked 
	 * @param y the y of the block being clicked
	 * @param z the z of the block being clicked
	 * @param placeDir the clicked face of the block
	 * @param dx x offset
	 * @param dy y offset
	 * @param dz z offset
	 */
	void sendBlockPlacementPacket(int x, int y, int z, int placeDir, float dx,
			float dy, float dz);
	/**
	 * Send destroy block packet to the server
	 * @param target the target block
	 * @param facing the face of the block clicked
	 */
	void sendDestoryBlockAt(BlockPos target, int facing);
	/**
	 * Set the players current holding item
	 * @param index the index of target item
	 * @return true if the current holding item was changed
	 */
	boolean setPlayerCurrentItem(int index);
	
	/**
	 * Build one block based on the coordinates passed in
	 * @param relativePos an integer array with relative x, y, z and a optional side face
	 * @param yaw the yaw of player
	 * @param x x offset
	 * @param y y offset
	 * @param z z offset
	 */
	void buildOneBlock(int[] relativePos, float yaw, double x, double y, double z);
	
	/**
	 * March toward and attack the named entity
	 * @param chosenName entity name
	 * @param waitMs the minimal wait time in milliseconds between consecutive attacks
	 * @return target dead or can't be attacked
	 */
	boolean marchAttackEntity(String chosenName, int waitMs);
	
	/**
	 * Start to record all player activities
	 * @param name the name used to identify the recorded activities
	 */
	void recordAllSteps(String name);
}
