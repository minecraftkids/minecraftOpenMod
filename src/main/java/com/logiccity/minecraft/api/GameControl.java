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
	@MovePlayerStart
	void pressForwardKey();
	/**
	 * Press the backward key
	 */
	@MovePlayerStart
	void pressBackKey();
	/**
	 * Press the left key
	 */
	@MovePlayerStart
	void pressLeftKey();
	/**
	 * Press the right key
	 */
	@MovePlayerStart
	void pressRightKey();
	/**
	 * Press the jump key
	 */
	@MovePlayerStart
	void pressJumpKey();
	/**
	 * Make the player jump once
	 */
	@MovePlayerStart
	void playerJumpOnce();
	
	/**
	 * Release the forward key
	 */
	@MovePlayerStop
	void releaseForwardKey();
	/**
	 * Release the backward key
	 */
	@MovePlayerStop
	void releaseBackKey();
	/**
	 * Release the left key
	 */
	@MovePlayerStop
	void releaseLeftKey();
	/**
	 * Release the right key
	 */
	@MovePlayerStop
	void releaseRightKey();
	/**
	 * Release the jump key
	 */
	@MovePlayerStop
	void releaseJumpKey();
	/**
	 * Clear player's XZ momentum so it will stop moving
	 */
	@MovePlayerStop
	void clearPlayerMotionXZ();
	
	/**
	 * Press the attack key
	 */
	@PlayerAttack
	void pressAttackKey();
	/**
	 * Release the attack key
	 */
	@PlayerAttack
	void releaseAttackKey();
	/**
	 * Send destroy block packet to the server
	 * @param target the target block
	 * @param facing the face of the block clicked
	 */
	@PlayerAttack
	void sendDestoryBlockAt(BlockPos target, int facing);
	/**
	 * March toward and attack the named entity
	 * @param chosenName entity name
	 * @param waitMs the minimal wait time in milliseconds between consecutive attacks
	 * @return target dead or can't be attacked
	 */
	@PlayerAttack
	boolean marchAttackEntity(String chosenName, int waitMs);
	/**
	 * Make the player swing current holding item
	 */
	@PlayerAttack
	void playerSwingItem();

	/**
	 * Set the player's rotation pitch to a new value
	 * @param pitch pitch
	 */
	@ChangePlayerStatus
	void setRotationPitch(float pitch);
	/**
	 * Set the player's rotation yaw to a new value
	 * @param yaw yaw
	 */
	@ChangePlayerStatus
	void setRotationYaw(float yaw);
	/**
	 * Press the sneak key
	 */
	@ChangePlayerStatus
	void pressSneakKey();
	/**
	 * Release the sneak key
	 */
	@ChangePlayerStatus
	void releaseSneakKey();
	/**
	 * Set the players current holding item
	 * @param index the index of target item
	 * @return true if the current holding item was changed
	 */
	@ChangePlayerStatus
	boolean setPlayerCurrentItem(int index);
	/**
	 * Teleport user to new x,y,z. Single player creative mode only
	 * @param x new x location
	 * @param y new y location
	 * @param z new z location
	 */
	@ChangePlayerStatus
	void setPlayerLocation(double x, double y, double z);
	
	/**
	 * Execute a command
	 * @param name the command name
	 * @param args arguments to the command
	 */
	@CommandAccess
	void executeCommand(String name, String[] args);
	
	/**
	 * Send block placement packet to the server
	 * @param x the x of the block being clicked 
	 * @param y the y of the block being clicked
	 * @param z the z of the block being clicked
	 * @param placeDir the clicked face of the block
	 */
	@BuildBlocks
	void sendBlockPlacementPacket(int x, int y, int z, int placeDir);
	/**
	 * Build one block based on the coordinates passed in
	 * @param relativePos an integer array with relative x, y, z and an optional side face
	 * @param yaw the yaw of player
	 * @param x x offset
	 * @param y y offset
	 * @param z z offset
	 */
	@BuildBlocks
	void buildOneBlock(int[] relativePos, float yaw, double x, double y, double z);
	
	/**
	 * Start to record player's block placements/destructions 
	 * @param name the name used to identify the recorded steps
	 */
//	@HelperUtils
	void recordBuildingSteps(String name);
	/**
	 * Start to record all player activities
	 * @param name the name used to identify the recorded activities
	 */
//	@HelperUtils
	void recordAllSteps(String name);
	/**
	 * Stop the current recording
	 */
//	@HelperUtils
	void stopRecordSteps();

	/**
	 * Send error level message to the chat log
	 * @param msg error message
	 */
	@ChatPrint
	void chatLogError(String msg);
	/**
	 * Send info level message to the chat log
	 * @param msg info message
	 */
	@ChatPrint
	void chatLogInfo(String msg);
	/**
	 * Send raw log to chat
	 * @param msg message
	 */
	@ChatPrint
	void chatLogRaw(String msg);

	public static @interface MovePlayerStart {}
	public static @interface MovePlayerStop {}
	public static @interface PlayerAttack {}
	public static @interface ChangePlayerStatus {}
	public static @interface BuildBlocks {}
	public static @interface ChatPrint {}
	public static @interface CommandAccess {}
//	public static @interface HelperUtils {}
}
