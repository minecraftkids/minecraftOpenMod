package com.logiccity.minecraft.api;

/**
 * Interface of command that only require a synchronous one time operation
 * 
 * @author Minecraftkids
 *
 */
public interface CommandInterface {
	/**
	 * Initialize the command
	 * @param args command arguments
	 */
	void initCmd(String[] args);
	/**
	 * Clean up the command
	 */
	public void cleanupCmd();
	/**
	 * Execute the synchronous one time operation
	 * @param args command arguments
	 */
	void execute(String[] args);
}
