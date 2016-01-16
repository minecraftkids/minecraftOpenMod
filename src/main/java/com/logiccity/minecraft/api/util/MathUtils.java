package com.logiccity.minecraft.api.util;

public class MathUtils {
	public static final float normalYaw(float yaw) {
		while (yaw > 180) {
			yaw -= 360;
		}
		while (yaw < -180) {
			yaw += 360;
		}
		return yaw;
	}

}
