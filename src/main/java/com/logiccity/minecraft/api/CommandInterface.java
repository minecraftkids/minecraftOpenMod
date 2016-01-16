package com.logiccity.minecraft.api;

public interface CommandInterface {
	void initCmd(String[] args);
	public void cleanupCmd();
	void execute(String[] args);
}
