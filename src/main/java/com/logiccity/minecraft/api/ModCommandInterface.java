package com.logiccity.minecraft.api;

public interface ModCommandInterface {	
	void initCmd(String[] args);
	public void cleanupCmd();
	boolean doInRenderTicThread();
	boolean doInUpdateTicThread();
}
