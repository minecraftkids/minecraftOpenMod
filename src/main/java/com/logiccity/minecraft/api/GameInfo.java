package com.logiccity.minecraft.api;

import java.util.ArrayList;
import java.util.List;

import com.logiccity.minecraft.api.BlocklyCatMarker.C_CommandAccess;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_BlockInfo;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerLocation;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerRotation;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerStatus;
//import com.logiccity.minecraft.api.GameControl.HelperUtils;

/**
 * The interface for retrieving player/game info
 * @author Minecraftkids
 *
 */
public interface GameInfo {
	/**
	 * Get current player's block location
	 * @return block pos
	 */
	@I_PlayerLocation
	BlockPos getPlayerBlockPos();
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
	 * Get another player's block location
	 * @param name player name
	 * @return block position
	 */
	@I_PlayerLocation
	BlockPos getPlayerLocation(String name);
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
	 * Check if the player is flying
	 * @return true if flying
	 */
	@I_PlayerStatus
	boolean isPlayerFlying();
	/**
	 * Check if the player is attempting to move
	 * @return true if player is attempting to move
	 */
	@I_PlayerStatus
	boolean isPlayerAttemptingMove();
	/**
	 * Check if the player is changing location
	 * @return true if player is changing location
	 */
	@I_PlayerStatus
	boolean isPlayerChaningLocation();
	/**
	 * Get the names of entities that are closest to the player
	 * @param count the number of entities names to return 
	 * @return list of names
	 */
	@I_PlayerStatus
	List<String> getClosestEntityNames(int count);
	/**
	 * Get the names of other players that are closest to the player
	 * @param count the number of names to return 
	 * @return list of names
	 */
	@I_PlayerStatus
	List<String> getClosestPlayerNames(int count);
	/**
	 * Get player mouse over block pos
	 * @return block pos
	 */
	@I_PlayerStatus
	BlockPos getMouseOverBlock();
	/**
	 * Check if the current game mode is creative
	 * @return true if in creative mode
	 */
	@I_PlayerStatus
	boolean isCreativeMode();

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
	
	List<String> getEntityClassInfo(String name);
}
