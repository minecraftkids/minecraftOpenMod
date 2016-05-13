package com.logiccity.minecraft.api;

/**
 * The interface for commands that requires continuously running asynchronous operations in 
 * update or render tic threads until certain conditions are met 
 * @author Minecraftkids
 *
 */
public interface ModCommandInterface {
	/**
	 * Initialize the command
	 * @param args command arguments
	 */
	void initCmd(String[] args);
	/**
	 * Cleanup the command
	 */
	public void cleanupCmd();
	/**
	 * Add a command to a list of commands that will be synchronously executed before next update invocation
	 * @param cmdName the name of the command
	 * @param args comma or space separated list of arguments
	 */
	void addToSyncCmds(String cmdName, String args);
	/**
	 * Invoke operations in the game tick thread which runs every few milliseconds
	 * @return true will cause the command to be stopped, false will cause the command to continue
	 */
	boolean doInUpdateTicThread();
	/**
	 * Perform main UI rendering in the game tick thread which runs every few milliseconds
	 * @return true will cause the command to be stopped, false will cause the command to continue
	 */
	boolean doInRenderTicThread();
	/**
	 * Perform additional rendering on top of the main rendering. Overwrite content below.
	 * @return true will cause the command to be stopped, false will cause the command to continue
	 */
	boolean doInPostInGameRenderTicThread();
	/**
	 * Configure this command based on user input from on the chat line. All command configuration
	 * chat inputs start with "/-"
	 * @param input the string after "/-"
	 * @return true will cause the command to be stopped, false will cause the command to continue
	 */
	boolean doInCmdInputThread(String input);
}
