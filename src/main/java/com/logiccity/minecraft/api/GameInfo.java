package com.logiccity.minecraft.api;

import java.util.ArrayList;
import java.util.List;

import com.logiccity.minecraft.api.BlocklyCatMarker.C_CommandAccess;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_BlockInfo;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_GameStatus;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_ClientStatus;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_MovementState;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerLocation;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerRotation;

/**
 * The interface for retrieving player/game info
 * @author Minecraftkids
 *
 */
public interface GameInfo {
	/**
	 * Get player x coordinate
	 * @return x
	 */
	@I_PlayerLocation
	double getPlayerPosX();
	/**
	 * Get player y coordinate
	 * @return y
	 */
	@I_PlayerLocation
	double getPlayerPosY();
	/**
	 * Get player z coordinate
	 * @return z
	 */
	@I_PlayerLocation
	double getPlayerPosZ();
	/**
	 * Get block location of an living entity
	 * @param name entity name or unique ID. null or empty string means current player
	 * @return block position
	 */
	@I_PlayerLocation
	BlockPos getLivingEntityLocation(String name);
	/**
	 * Get the square distance form the player to a point
	 * @param x the point's x coordinate
	 * @param y the point's y coordinate
	 * @param z the point's z coordinate
	 * @return the square distance
	 */
	@I_PlayerLocation
	double getPlayerDistanceSq(double x, double y, double z);

	/**
	 * Get player's rotation yaw
	 * @return yaw
	 */
	@I_PlayerRotation
	float getRotationYaw();
	/**
	 * Get player's rotation pitch
	 * @return pitch
	 */
	@I_PlayerRotation
	float getRotationPitch();
	/**
	 * Get player's rotation yaw at the previous tic
	 * @return yaw
	 */
	@I_PlayerRotation
	float getPreviousRotationYaw();
	/**
	 * Get player's rotation pitch at the previous tic
	 * @return pitch
	 */
	@I_PlayerRotation
	float getPreviousRotationPitch();
	/**
	 * The distance between the projected block that another player is directly facing and the current player
	 * @param playerName the other player's name
	 * @return the [yaw, pitch] distances in blocks 
	 */
	@I_PlayerRotation
	float[] lookAtMeDelta(String playerName);
	/**
	 * The calculated yaw for the player to face a block horizontally
	 * @param bp the position of a block
	 * @return the calculated yaw to face the block
	 */
	@I_PlayerRotation
	float faceBlockYaw(BlockPos bp);

	/**
	 * Check if the player is flying
	 * @return true if flying
	 */
	@I_MovementState
	boolean isPlayerFlying();
	/**
	 * Check if the player collided horizontally
	 * @return true if player has collided with something on X- or Z-axis
	 */
	@I_MovementState
	boolean isPlayerCollidedHorizontally();
	/**
	 * Check if the player is changing location
	 * @return true if player is changing location
	 */
	@I_MovementState
	boolean isPlayerChaningLocation();
	/**
	 * Get the speed that the player is moving forward
	 * @return the speed that player is moving forward(>0) or backward(<0)
	 */
	@I_MovementState
	float getPlayerForwardSpeed();
	
	/**
	 * Check if the player is sneaking
	 * @return if the player is sneaking
	 */
	@I_ClientStatus
	boolean isKeySneakPressed();
	/**
	 * Is the current player pressing the UseItem key (mouse key)
	 * @return if the UseItem key is pressed
	 */
	@I_ClientStatus
	boolean isKeyUseItemPressed();
	/**
	 * Is the current player pressing the Attack key (mouse key)
	 * @return if the Attack key is pressed
	 */
	@I_ClientStatus
	boolean isKeyAttackPressed();
	/**
	 * Is the jump key pressed
	 * @return if the jump key pressed
	 */
	@I_ClientStatus
	boolean isKeyJumpPressed();
	/**
	 * Get player mouse over block pos
	 * @return block pos
	 */
	@I_ClientStatus
	BlockPos getMouseOverBlock();
	/**
	 * Get the item unlocalized name that a player is holding
	 * @param playerName A player's name, use null or empty string for the current user
	 * @return item's unlocalized name
	 */
	@I_ClientStatus
	String holdingItemUnlocalizedName(String playerName);

	/**
	 * Get the names of entities that are closest to the player
	 * @param count the number of names to return 
	 * @param playerOnly if only players are included
	 * @return list of names
	 */
	@I_GameStatus
	List<String> getClosestEntityNames(int count, boolean playerOnly);
	/**
	 * Check if the current game mode is creative
	 * @return true if in creative mode
	 */
	@I_GameStatus
	boolean isCreativeMode();

	/**
	 * Check if the material on a block is solid
	 * @param pos the block position
	 * @return true if solid
	 */
	@I_BlockInfo
	boolean isSolid(BlockPos pos);
	/**
	 * Check if a block is safe to walk on
	 * @param pos block position
	 * @return true if safe
	 */
	@I_BlockInfo
	boolean isSafeWalkOn(BlockPos pos);
	/**
	 * Check if a block material is ladder
	 * @param pos block position
	 * @return true if ladder
	 */
	@I_BlockInfo
	boolean isLadder(BlockPos pos);
	/**
	 * Check if a block is in water
	 * @param pos block position
	 * @return true if in water
	 */
	@I_BlockInfo
	boolean isInWater(BlockPos pos);
	
	/**
	 * Check if the named command is running
	 * @param name command name
	 * @return true if command is running
	 */
	@C_CommandAccess
	boolean isCommandRunning(String name);
	/**
	 * Check if any other command is running
	 * @param excludes comma separated command names to be excluded from checking
	 * @return true if any other command is running
	 */
	boolean isAnyCommandRunning(String excludes);
	/**
	 * Check if the named mod is enabled 
	 * @param name mod name
	 * @return true if enabled
	 */
	@C_CommandAccess
	boolean isModEnabled(String name);
	
	/**
	 * Load previously recorded building steps
	 * @param name the name of the recording
	 * @return a ArrayList of steps
	 */
//	@I_HelperUtils
	ArrayList<BuildStepRecord> loadRecordedBuildingSteps(String name);
	/**
	 * Generated a random 2-D maze 
	 * @param columns the number of path ways in each row
	 * @param rows the number of path ways in each column 
	 * @return a 2-D boolean array with true as wall blocks
	 */
//	@I_HelperUtils
	boolean [][] generateMaze(int columns, int rows);
	
	/**
	 * Get health of a living entity
	 * @param name the name of the entity
	 * @return the health number or -1 if entity died or does not exist
	 */
	@I_GameStatus
	float getLivingEntityHealth(String name);
	/**
	 * Get the entity with the smallest angle to the direction the player is facing
	 * @return names for players or unique ID for non-players
	 */
	@I_GameStatus
	String getClosestFacingAngleEntity();
	/**
	 * If the player is on the ground
	 * @return if the player is on the ground
	 */
	@I_ClientStatus
	boolean isPlayerOnGround();
	/**
	 * Get the vertical motion of the current player
	 * @return the vertical motion
	 */
	@I_ClientStatus
	double getPlayerMotionY();
	/**
	 * Get the current brightness level of the world
	 * @return the brightness level
	 */
	@I_GameStatus
	float getWorldBrightness();
}
