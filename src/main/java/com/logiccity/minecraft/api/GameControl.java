package com.logiccity.minecraft.api;

import com.logiccity.minecraft.api.BlocklyCatMarker.C_ChatPrint;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_CommandAccess;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_ControlKeys;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_PlayerAttack;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_RenderUI;
import com.logiccity.minecraft.api.BlocklyCatMarker.C_ServerPacket;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_BlockInfo;
import com.logiccity.minecraft.api.BlocklyCatMarker.I_ClientStatus;
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
	 * Press or release the forward key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseForwardKey(boolean press);
	/**
	 * Press or release the backward key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseBackKey(boolean press);
	/**
	 * Press or release the left key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseLeftKey(boolean press);
	/**
	 * Press or release the right key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseRightKey(boolean press);
	/**
	 * Press or release the jump key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseJumpKey(boolean press);
	/**
	 * Press or release the sneak key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseSneakKey(boolean press);
	/**
	 * Press or release the sprint key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseSprintKey(boolean press);
	/**
	 * Press Release the attack key
	 * @param press 'true' for press; 'false' for release
	 */
	@C_ControlKeys
	void pressReleaseAttackKey(boolean press);
	/**
	 * Press and immediately release the jump key to make the player jump once
	 */
	@C_ControlKeys
	void playerJumpOnce();
	/**
	 * Prevent the normal mouse click event
	 * @param prevent true to prevent event; false to restore the default
	 */
	@C_ControlKeys
	void setPreventClientClick(boolean prevent);

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
	 * Enable/Disable the knock back effect on the player
     * @param enabled false will disable knock back effect
	 */
	@C_PlayerAttack
	void setPlayerKnockBackEnabled(boolean enabled);
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
	 * Calculate and set player yaw and pitch so the bow/arrow is point at a target
	 * @param target intended target
	 */
	@C_PlayerAttack
	void pointArrowAt(String target);
	
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
	 * Set if the player is on ground on the client side
	 * @param onGround
	 */
	@I_PlayerLocation
	void setPlayerOnGround(boolean onGround);
	/**
	 * Set the current player's x, y, z location on the client side
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
	 * Stop a command 
	 * @param name command name
	 */
	@C_CommandAccess
	void stopCommand(String name);

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
	 * Set the player's Y motion
	 * @param my new Y motion
	 */
	@I_MovementState
	void setPlayerMotionY(double my);
	/**
	 * Clear player's XZ motion so it will stop moving
	 */
	@I_MovementState
	void clearPlayerMotionXZ();
	/**
	 * Set the sprinting state of the player
	 * @param sprinting sprinting on or off
	 */
	@I_MovementState
	void setPlayerSprinting(boolean sprinting);
	/**
	 * Set the player fall distance on the client side
	 * @param f fall distance
	 */
	@I_MovementState
	void setPlayerFallDistance(float f);
	
	/**
	 * Set the players current holding item
	 * @param index the index of target item
	 * @return true if the current holding item was changed
	 */
	@I_ClientStatus
	boolean setPlayerCurrentItem(int index);
	/**
	 * Set the factor that determines how far the player will move each tick if it is jumping or falling
	 * @param f the factor which is 0.02 by default
	 */
	@I_ClientStatus
	void setJumpMovementFactor(float f);
	/**
	 * Clear the player's InWeb status
	 */
	@I_ClientStatus
	void setPlayerNotInWeb();
	
	/**
	 * Set the brightness level of the world
	 * @param gamma brightness level
	 */
	@I_GameStatus
	void setWorldBrightness(float gamma);
	/**
	 * Update Base Finder render blocks such as wood, rail, fence and etc 
	 */
	@I_GameStatus
	void baseFinderUpdate();
	/**
	 * Clone a fake player with an Id in client world
	 * @param id the id of fake player
	 */
	@I_GameStatus
	void cloneFakePlayer(int id);
	/**
	 * Remove an entity from the client world
	 * @param id the id of the entity
	 */
	@I_GameStatus
	void removeEntityAndRenderWorld(int id);
	
	/**
	 * Highlight an entity in render thread
	 * @param entityName 
	 * @param colorMode
	 */
	@C_RenderUI
	void renderHighlightEntity(String entityName, int colorMode);
	/**
	 * Highlight all invisible living entities
	 */
	@C_RenderUI
	void renderInvisibleLivingEntities();
	/**
	 * Render tracers to all loaded players
	 */
	@C_RenderUI
	void renderPlayerTracers();
	/**
	 * Render highlight of chests in the game
	 * @param maxChests the limit on number of positions returned
	 * @return if maximum limit reached
	 */
	@C_RenderUI
	boolean renderChestEsp(int maxChests);
	/**
	 * Refresh all UI renderers
	 */
	@C_RenderUI
	void refreshRenderers();
	/**
	 * Set the size of name above the heads of entities
	 * @param size the size. Default: 1
	 */
	@C_RenderUI
	void setPlayerLabelScale(float size);
	/**
	 * Render armor status of the player. Called in render thread
	 */
	@C_RenderUI
	void renderPlayerArmorStatus();
	/**
	 * Initialize Base Finder limits
	 * @param maxBlocks max artificial blocks to be rendered
	 * @param range max range of blocks
	 */
	@C_RenderUI
	void initBaseFinder(int maxBlocks, int range);
	/**
	 * Render artificial blocks in Base Finder
	 */
	@C_RenderUI
	void baseFinderRender();
	
	/**
	 * Stop sending certain packages to the Minecraft server
	 * @param types comma separated list of: '1': Attack/Release/Dig; '2': Placement; '3': All others
	 */
	@C_ServerPacket
	void stopSendingPackagesToServer(String types);
	/**
	 * Send packet to simulate the pressing UseItem (mouse key) action by the current user
	 */
	@C_ServerPacket
	void simulateUseItemKeyPress();
	/**
	 * Send packet to simulate the releasing UseItem (mouse key) action by the current user
	 */
	@C_ServerPacket
	void simulateUseItemKeyRelease();
	/**
	 * Send a packet to server to simulate a time unit has passed
	 */
	@C_ServerPacket
	void simulateTimeUnitPassed();
	/**
	 * Send a packet to server to indicate player position
	 * @param posX player x
	 * @param posY player y
	 * @param posZ player z
	 * @param isOnGround if the player is on the ground
	 */
	@C_ServerPacket
	void sendPlayerPositionPacketToServer(double posX, double posY, double posZ, boolean isOnGround);
	/**
	 * Send fake packet to server to indicate on ground status if the player is falling
	 */
	@C_ServerPacket
	void sendFakeOnGroundPackageIfFalling();
	/**
	 * Send packets to server to face an entity and attack it. 
	 * @param en the name of the entity
	 */
	@C_ServerPacket
	void sendFaceEntityAttackPackets(String en);
	/**
	 * Send packet to server in start or stop sneaking
	 * @param start true for start; false for stop
	 */
	@C_ServerPacket
	void sendSneakingStartStopPacket(boolean start);
}
