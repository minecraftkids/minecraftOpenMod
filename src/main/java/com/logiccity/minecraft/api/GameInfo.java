package com.logiccity.minecraft.api;

import java.util.ArrayList;
import java.util.List;

import com.logiccity.minecraft.api.GameControl.CommandAccess;
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
	@PlayerLocation
	BlockPos getPlayerBlockPos();
	/**
	 * Get player x coordinate
	 * @return x
	 */
	@PlayerLocation
	double getPlayerPosX();
	/**
	 * Get player y coordinate
	 * @return y
	 */
	@PlayerLocation
	double getPlayerPosY();
	/**
	 * Get player z coordinate
	 * @return z
	 */
	@PlayerLocation
	double getPlayerPosZ();
	/**
	 * Get another player's block location
	 * @param name player name
	 * @return block position
	 */
	@PlayerLocation
	BlockPos getPlayerLocation(String name);
	/**
	 * Get the square distance form the player to a point
	 * @param x the point's x coordinate
	 * @param y the point's y coordinate
	 * @param z the point's z coordinate
	 * @return the square distance
	 */
	@PlayerLocation
	double getPlayerDistanceSq(double x, double y, double z);

	/**
	 * Get player's rotation yaw
	 * @return yaw
	 */
	@PlayerRotation
	float getRotationYaw();
	/**
	 * Get player's rotation pitch
	 * @return pitch
	 */
	@PlayerRotation
	float getRotationPitch();
	/**
	 * Get player's rotation yaw at the previous tic
	 * @return yaw
	 */
	@PlayerRotation
	float getPreviousRotationYaw();
	/**
	 * Get player's rotation pitch at the previous tic
	 * @return pitch
	 */
	@PlayerRotation
	float getPreviousRotationPitch();
	
	/**
	 * Check if the material on a block is solid
	 * @param pos the block position
	 * @return true if solid
	 */
	@BlockInfo
	boolean isSolid(BlockPos pos);
	/**
	 * Check if a block is safe to walk on
	 * @param pos block position
	 * @return true if safe
	 */
	@BlockInfo
	boolean isSafeWalkOn(BlockPos pos);
	/**
	 * Check if a block material is ladder
	 * @param pos block position
	 * @return true if ladder
	 */
	@BlockInfo
	boolean isLadder(BlockPos pos);
	/**
	 * Check if a block is in water
	 * @param pos block position
	 * @return true if in water
	 */
	@BlockInfo
	boolean isInWater(BlockPos pos);
	
	/**
	 * Check if the player is flying
	 * @return true if flying
	 */
	@PlayerStatus
	boolean isPlayerFlying();
	/**
	 * Check if the player is attempting to move
	 * @return true if player is attempting to move
	 */
	@PlayerStatus
	boolean isPlayerAttemptingMove();
	/**
	 * Check if the player is changing location
	 * @return true if player is changing location
	 */
	@PlayerStatus
	boolean isPlayerChaningLocation();
	/**
	 * Get the names of entities that are closest to the player
	 * @param count the number of entities names to return 
	 * @return list of names
	 */
	@PlayerStatus
	List<String> getClosestEntityNames(int count);
	/**
	 * Get player mouse over block pos
	 * @return block pos
	 */
	@PlayerStatus
	BlockPos getMouseOverBlock();
	/**
	 * Check if the current game mode is creative
	 * @return true if in creative mode
	 */
	@PlayerStatus
	boolean isCreativeMode();
		
	/**
	 * Check if the named command is running
	 * @param name command name
	 * @return true if command is running
	 */
	@CommandAccess
	boolean isCommandRunning(String name);
	/**
	 * Check if the named mod is enabled 
	 * @param name mod name
	 * @return true if enabled
	 */
	@CommandAccess
	boolean isModEnabled(String name);
	
	/**
	 * Load previously recorded building steps
	 * @param name the name of the recording
	 * @return a ArrayList of steps
	 */
//	@HelperUtils
	ArrayList<BuildStepRecord> loadRecordedBuildingSteps(String name);
	/**
	 * Generated a random 2-D maze 
	 * @param columns the number of path ways in each row
	 * @param rows the number of path ways in each column 
	 * @return a 2-D boolean array with true as wall blocks
	 */
//	@HelperUtils
	boolean [][] generateMaze(int columns, int rows);
	
	public static @interface PlayerLocation {}
	public static @interface PlayerRotation {}
	public static @interface BlockInfo {}
	public static @interface PlayerStatus {}
}
