package com.logiccity.minecraft.api;

import java.util.ArrayList;
import java.util.List;

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
	double getPlayerPosX();
	/**
	 * Get player y coordinate
	 * @return y
	 */
	double getPlayerPosY();
	/**
	 * Get player z coordinate
	 * @return z
	 */
	double getPlayerPosZ();
	/**
	 * Get the square distance form the player to a point
	 * @param x the point's x coordinate
	 * @param y the point's y coordinate
	 * @param z the point's z coordinate
	 * @return the square distance
	 */
	double getPlayerDistanceSq(double x, double y, double z);
	/**
	 * Get player's rotation yaw
	 * @return yaw
	 */
	float getRotationYaw();
	/**
	 * Get player's rotation pitch
	 * @return pitch
	 */
	float getRotationPitch();
	/**
	 * Get player's rotation yaw at the previous tic
	 * @return yaw
	 */
	float getPreviousRotationYaw();
	/**
	 * Get player's rotation pitch at the previous tic
	 * @return pitch
	 */
	float getPreviousRotationPitch();
	/**
	 * Get player's block pos
	 * @return block pos
	 */
	BlockPos getPlayerBlockPos();
	/**
	 * Check if the material on a block is solid
	 * @param pos the block position
	 * @return true if solid
	 */
	boolean isSolid(BlockPos pos);
	/**
	 * Check if a block is safe to walk on
	 * @param pos block position
	 * @return true if safe
	 */
	boolean isSafeWalkOn(BlockPos pos);
	/**
	 * Check if a block material is ladder
	 * @param pos block position
	 * @return true if ladder
	 */
	boolean isLadder(BlockPos pos);
	/**
	 * Check if the named mod is enabled 
	 * @param name mod name
	 * @return true if enabled
	 */
	boolean isModEnabled(String name);
	/**
	 * Check if the current game mode is creative
	 * @return true if in creative mode
	 */
	boolean isCreativeMode();
	/**
	 * Check if the player is flying
	 * @return true if flying
	 */
	boolean isPlayerFlying();
	/**
	 * Check if a block is in water
	 * @param pos block position
	 * @return true if in water
	 */
	boolean isInWater(BlockPos pos);
	/**
	 * Check if the named command is running
	 * @param name command name
	 * @return true if command is running
	 */
	boolean isCommandRunning(String name);
	/**
	 * Load previously recorded building steps
	 * @param name the name of the recording
	 * @return a ArrayList of steps
	 */
	ArrayList<BuildStepRecord> loadRecordedBuildingSteps(String name);
	/**
	 * Check if the player is attempting to move
	 * @return true if player is attempting to move
	 */
	boolean isPlayerAttemptingMove();
	/**
	 * Check if the player is changing location
	 * @return true if player is changing location
	 */
	boolean isPlayerChaningLocation();
	/**
	 * Get the names of entities that are closest to the player
	 * @param count the number of entities names to return 
	 * @return list of names
	 */
	List<String> getClosestEntityNames(int count);
	
	/**
	 * Generated a random 2-D maze 
	 * @param columns the number of path ways in each row
	 * @param rows the number of path ways in each column 
	 */
	boolean [][] generateMaze(int columns, int rows);
	
	/**
	 * Get player mouse over block pos
	 * @return block pos
	 */
	BlockPos getMouseOverBlock();
}
