/*
 * Copyright © 2014 - 2015 Alexander01998 and contributors
 * All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.logiccity.minecraft.api.util;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.GameInfo;
import com.logiccity.minecraft.api.impl.ApiCommandBase;

public class PathUtils {
	public static boolean isSafe(BlockPos pos) {
		GameInfo gi = ApiCommandBase.getGameInfo();
		return (! gi.isSolid(pos)) && gi.isSafeWalkOn(pos.add(0, -1, 0));
	}

	public static boolean isFallable(BlockPos pos) {
		GameInfo gi = ApiCommandBase.getGameInfo();
		for (int i = -1; i >= (isNoFall() ? -256 : -3); i--) {
			if (gi.isSolid(pos.add(0, i, 0))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSolid(double x, double y, double z) {
		return ApiCommandBase.getGameInfo().isSolid(new BlockPos(x, y, z));
	}
	
	public static boolean isClimbable(BlockPos pos) {
		GameInfo gi = ApiCommandBase.getGameInfo();
		if (gi.isSolid(pos.add(0, -1, 0)) || gi.isLadder(pos)) {
			if (gi.isSolid(pos.add(0, 0, -1)) || gi.isSolid(pos.add(0, 0, 1))
					|| gi.isSolid(pos.add(1, 0, 0))
					|| gi.isSolid(pos.add(-1, 0, 0))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNoFall() {
		GameInfo gi = ApiCommandBase.getGameInfo();
		return gi.isModEnabled("NoFall") || gi.isCreativeMode();
	}

	public static boolean isFlyable(BlockPos pos) {
		GameInfo gi = ApiCommandBase.getGameInfo();
		return gi.isModEnabled("Flight") || gi.isPlayerFlying()
				|| gi.isInWater(pos);
	}

	public static int getCost(BlockPos next) {
		if (ApiCommandBase.getGameInfo().isInWater(next)) {
			return 3;
		}
		return 1;
	}
}
