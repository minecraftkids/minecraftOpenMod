package com.logiccity.minecraft.api;

import com.logiccity.minecraft.api.BlocklyCatMarker.C_BuildBlocks;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_ChangePlayerStatus;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_ChatPrint;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_CommandAccess;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_MovePlayerStart;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_MovePlayerStop;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_PlayerAttack;

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
	@C_MovePlayerStart
	void pressForwardKey();
	/**
	 * Press the backward key
	 */
	@C_MovePlayerStart
	void pressBackKey();
	/**
	 * Press the left key
	 */
	@C_MovePlayerStart
	void pressLeftKey();
	/**
	 * Press the right key
	 */
	@C_MovePlayerStart
	void pressRightKey();
	/**
	 * Press the jump key
	 */
	@C_MovePlayerStart
	void pressJumpKey();
	/**
	 * Make the player jump once
	 */
	@C_MovePlayerStart
	void playerJumpOnce();
	
	/**
	 * Release the forward key
	 */
	@C_MovePlayerStop
	void releaseForwardKey();
	/**
	 * Release the backward key
	 */
	@C_MovePlayerStop
	void releaseBackKey();
	/**
	 * Release the left key
	 */
	@C_MovePlayerStop
	void releaseLeftKey();
	/**
	 * Release the right key
	 */
	@C_MovePlayerStop
	void releaseRightKey();
	/**
	 * Release the jump key
	 */
	@C_MovePlayerStop
	void releaseJumpKey();
	/**
	 * Clear player's XZ momentum so it will stop moving
	 */
	@C_MovePlayerStop
	void clearPlayerMotionXZ();
	
	/**
	 * Press the attack key
	 */
	@C_PlayerAttack
	void pressAttackKey();
	/**
	 * Release the attack key
	 */
	@C_PlayerAttack
	void releaseAttackKey();
	/**
	 * Send destroy block packet to the server
	 * @param target the target block
	 * @param facing the face of the block clicked
	 */
	@C_PlayerAttack
	void sendDestoryBlockAt(BlockPos target, int facing);
	/**
	 * March toward and attack the named entity
	 * @param chosenName entity name
	 * @param waitMs the minimal wait time in milliseconds between consecutive attacks
	 * @return target dead or can't be attacked
	 */
	@C_PlayerAttack
	boolean marchAttackEntity(String chosenName, int waitMs);
	/**
	 * Make the player swing current holding item
	 */
	@C_PlayerAttack
	void playerSwingItem();

	/**
	 * Set the player's rotation pitch to a new value
	 * @param pitch pitch
	 */
	@C_ChangePlayerStatus
	void setRotationPitch(float pitch);
	/**
	 * Set the player's rotation yaw to a new value
	 * @param yaw yaw
	 */
	@C_ChangePlayerStatus
	void setRotationYaw(float yaw);
	/**
	 * Press the sneak key
	 */
	@C_ChangePlayerStatus
	void pressSneakKey();
	/**
	 * Release the sneak key
	 */
	@C_ChangePlayerStatus
	void releaseSneakKey();
	/**
	 * Set the players current holding item
	 * @param index the index of target item
	 * @return true if the current holding item was changed
	 */
	@C_ChangePlayerStatus
	boolean setPlayerCurrentItem(int index);
	/**
	 * Teleport user to new x,y,z. Single player creative mode only
	 * @param x new x location
	 * @param y new y location
	 * @param z new z location
	 */
	@C_ChangePlayerStatus
	void setPlayerLocation(double x, double y, double z);
	
	/**
	 * Execute a command
	 * @param name the command name
	 * @param args arguments to the command
	 */
	@C_CommandAccess
	void executeCommand(String name, String[] args);
	
	/**
	 * Send block placement packet to the server
	 * @param x the x of the block being clicked 
	 * @param y the y of the block being clicked
	 * @param z the z of the block being clicked
	 * @param placeDir the clicked face of the block
	 */
	@C_BuildBlocks
	void sendBlockPlacementPacket(int x, int y, int z, int placeDir);
	/**
	 * Build one block based on the coordinates passed in
	 * @param relativePos an integer array with relative x, y, z and an optional side face
	 * @param yaw the yaw of player
	 * @param x x offset
	 * @param y y offset
	 * @param z z offset
	 */
	@C_BuildBlocks
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
	@C_ChatPrint
	void chatLogError(String msg);
	/**
	 * Send info level message to the chat log
	 * @param msg info message
	 */
	@C_ChatPrint
	void chatLogInfo(String msg);
	/**
	 * Send raw log to chat
	 * @param msg message
	 */
	@C_ChatPrint
	void chatLogRaw(String msg);
}
