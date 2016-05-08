package com.logiccity.minecraft.api;

import com.logiccity.minecraft.api.BlocklyCatMarker.C_ChatPrint;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_CommandAccess;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_MovePlayerStart;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_MovePlayerStop;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_PlayerAttack;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_BlockInfo;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_GameStatus;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_MovementState;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerLocation;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_PlayerRotation;

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
	 * Press the sneak key
	 */
	@C_MovePlayerStart
	void pressSneakKey();
	/**
	 * Press the sprint key
	 */
	@C_MovePlayerStart
	void pressSprintKey();

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
	 * Release the sneak key
	 */
	@C_MovePlayerStop
	void releaseSneakKey();
	/**
	 * Release the sprint key
	 */
	@C_MovePlayerStop
	void releaseSprintKey();

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
	 * Disable player knock back
	 */
	@C_PlayerAttack
	void disablePlayerKnockBack();
	/**
	 * Enable player knock back. This is the default behavior
	 */
	@C_PlayerAttack
	void enablePlayerKnockBack();
	/**
	 * Initialize armor status UI
     * @param listMode armor list mode: 'horizontal' or 'vertical'
     * @param alignMode UI align mode: 'bottomLeft', 'bottomCenter', or 'bottomRight'
     * @param showPercent whether show damage as percentage
     * @param showMaxDamage whether to show max damage
	 */
	@C_PlayerAttack
	void initArmorStatusUI(String listMode, String alignMode, boolean showPercent, boolean showMaxDamage);
	/**
	 * Render armor status of the player. Called in render thread
	 */
	@C_PlayerAttack
	void renderPlayerArmorStatus();
	
	/**
	 * Set the player's rotation pitch to a new value
	 * @param pitch pitch
	 */
	@I_PlayerRotation
	void setRotationPitch(float pitch);
	/**
	 * Set the player's rotation yaw to a new value
	 * @param yaw yaw
	 */
	@I_PlayerRotation
	void setRotationYaw(float yaw);

	/**
	 * Teleport user to new x,y,z. Single player creative mode only
	 * @param x new x location
	 * @param y new y location
	 * @param z new z location
	 */
	@I_PlayerLocation
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
	@I_BlockInfo
	void sendBlockPlacementPacket(int x, int y, int z, int placeDir);
	/**
	 * Build one block based on the coordinates passed in
	 * @param relativePos an integer array with relative x, y, z and an optional side face
	 * @param yaw the yaw of player
	 * @param x x offset
	 * @param y y offset
	 * @param z z offset
	 */
	@I_BlockInfo
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
	 * Send warning level message to the chat log
	 * @param msg warning message
	 */
	@C_ChatPrint
	void chatLogWarning(String msg);
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
	
	/**
	 * Set the sprinting state of the player
	 * @param sprinting sprinting on or off
	 */
	@I_MovementState
	void setPlayerSprinting(boolean sprinting);
	
	/**
	 * Set the players current holding item
	 * @param index the index of target item
	 * @return true if the current holding item was changed
	 */
	@I_GameStatus
	boolean setPlayerCurrentItem(int index);
	/**
	 * Initialize Base Finder limits
	 * @param maxBlocks max artificial blocks to be rendered
	 * @param range max range of blocks
	 */
	@I_GameStatus
	void initBaseFinder(int maxBlocks, int range);
	/**
	 * Called in render thread to show artificial blocks
	 */
	@I_GameStatus
	void baseFinderRender();
	/**
	 * Update Base Finder blocks
	 */
	@I_GameStatus
	void baseFinderUpdate();
	/**
	 * Called in render thread to highlight an entity
	 * @param entityName 
	 * @param colorMode
	 */
	void renderHighlightEntity(String entityName, int colorMode);
	/**
	 * Stop sending certain packages to the Minecraft server
	 * @param types comma separated list of: '1': Attack/Release/Dig; '2': Placement; '3': All others
	 */
	void stopSendingPackagesToServer(String types);
	/**
	 * Prevent client click event
	 * @param b 
	 */
	void setPreventClientClick(boolean b);
	/**
	 * Simulate the pressing UseItem (mouse key) action by the current user
	 */
	void simulateUseItemKeyPress();
	/**
	 * Simulate the releasing UseItem (mouse key) action by the current user
	 */
	void simulateUseItemKeyRelease();
	/**
	 * Send a packet to server to simulate a time unit has passed
	 */
	void simulateTimeUnitPassed();
	/**
	 * Calculate and set player yaw and pitch so the bow/arrow is point at a target
	 * @param target intended target
	 */
	void pointArrowAt(String target);
	/**
	 * Send a packet to server to indicate player position
	 * @param posX player x
	 * @param posY player y
	 * @param posZ player z
	 * @param isOnGround if the player is on the ground
	 */
	void sendPlayerPositionPacketToServer(double posX, double posY, double posZ, boolean isOnGround);
	/**
	 * Set the Y motion of the current player
	 * @param my new Y motion
	 */
	void setPlayerMotionY(double my);
	/**
	 * Clone a fake player with an Id in client world
	 * @param id the id of fake player
	 */
	void cloneFakePlayer(int id);
	/**
	 * Remove an entity from the client world
	 * @param id the id of the entity
	 */
	void removeEntityAndRenderWorld(int id);
	/**
	 * Set the factor that determines how far the player will move each tick if it is jumping or falling
	 * @param f the factor which is 0.02 by default
	 */
	void setJumpMovementFactor(float f);
	/**
	 * Set the brightness level of the world
	 * @param gamma brightness level
	 */
	void setWorldBrightness(float gamma);
	/**
	 * Send packets to server to face an entity and attack it. 
	 * @param en the name of the entity
	 */
	void sendFaceEntityAttackPackets(String en);
	/**
	 * Invoke a method on a command
	 * @param cmdName command name
	 * @param method method name
	 */
	void executeCommandMethod(String cmdName, String method);
	/**
	 * Set the size of name above the heads of entities
	 * @param size the size. Default: 1
	 */
	void setPlayerLabelScale(float size);
	/**
	 * Send fake packet to server to indicate on ground status if the player is falling
	 */
	void sendFakeOnGroundPackageIfFalling();
	/**
	 * Clear the player's InWeb status
	 */
	void setPlayerNotInWeb();
	/**
	 * Send packet to server in start or stop sneaking
	 * @param start true for start; false for stop
	 */
	void sendSneakingStartStopPacket(boolean start);
	/**
	 * Highlight all invisible living entities
	 */
	void renderInvisibleLivingEntities();
	/**
	 * Render tracers to all loaded players
	 */
	void renderPlayerTracers();
	/**
	 * Refresh all UI renderers
	 */
	void refreshRenderers();
}
