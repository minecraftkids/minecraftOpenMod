package com.logiccity.minecraft.api.util;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.GameInfo;

public class PathUtils {
	public static boolean isSafe(BlockPos pos, GameInfo gi) {
		return (! gi.isSolid(pos)) && gi.isSafeWalkOn(pos.add(0, -1, 0));
	}

	public static boolean isFallable(BlockPos pos, GameInfo gi) {
		for (int i = -1; i >= ((gi.isCommandRunning("NoFall") || gi.isCreativeMode()) ? -256 : -3); i--) {
			if (gi.isSolid(pos.add(0, i, 0))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isClimbable(BlockPos pos, GameInfo gi) {
		if (gi.isSolid(pos.add(0, -1, 0)) || gi.isLadder(pos)) {
			if (gi.isSolid(pos.add(0, 0, -1)) || gi.isSolid(pos.add(0, 0, 1))
					|| gi.isSolid(pos.add(1, 0, 0))
					|| gi.isSolid(pos.add(-1, 0, 0))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isFlyable(BlockPos pos, GameInfo gi) {
		return gi.isCommandRunning("Flight") || gi.isPlayerFlying()
				|| gi.isInWater(pos);
	}

	public static int getCost(BlockPos next, GameInfo gi) {
		if (gi.isInWater(next)) {
			return 3;
		}
		return 1;
	}
}
