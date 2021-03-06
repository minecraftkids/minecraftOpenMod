package com.logiccity.minecraft.api.impl;

import com.logiccity.minecraft.api.CommandInterface;

public abstract class CustomCommandBase extends ApiCommandBase implements CommandInterface {
	protected CustomCommandBase(String name, int... args) {
		super(name, args);
	}
	protected CustomCommandBase(String name, String keyChar, int... args) {
		super(name, keyChar, args);
	}
}
