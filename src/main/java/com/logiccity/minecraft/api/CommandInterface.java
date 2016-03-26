package com.logiccity.minecraft.api;

/**
 * Interface of command that only require a synchronous one time operation
 * 
 * @author Minecraftkids
 *
 */
public interface CommandInterface {
	/**
	 * Execute the synchronous one time operation
	 * @param args command arguments
	 */
	void execute(String[] args);
}
