package com.logiccity.minecraft.api.util;

import java.util.ArrayList;

import com.logiccity.minecraft.api.BlockPos;
import com.logiccity.minecraft.api.GameInfo;

public class PathPoint {
	private BlockPos pos;
	private PathPoint previous;
	private int priority;
	private int movementCost;
	private GameInfo gameInfo;

	public PathPoint(BlockPos pos, PathPoint previous, int movementCost,
			int priority, GameInfo gi) {
		this.pos = pos;
		this.previous = previous;
		this.movementCost = movementCost;
		this.priority = priority;
		gameInfo = gi;
	}

	public ArrayList<BlockPos> getNeighbors() {
		BlockPos playerPos = gameInfo.getLivingEntityLocation(null);
		ArrayList<BlockPos> neighbors = new ArrayList<BlockPos>();
		neighbors.add(pos.add(0, 0, -1));// north
		neighbors.add(pos.add(0, 0, 1));// south
		neighbors.add(pos.add(1, 0, 0));// east
		neighbors.add(pos.add(-1, 0, 0));// west
		neighbors.add(pos.add(-1, 0, -1));// Add corners
		neighbors.add(pos.add(-1, 0, 1));
		neighbors.add(pos.add(1, 0, 1));
		neighbors.add(pos.add(1, 0, -1));
		for (int i = neighbors.size() - 1; i > -1; i--) {
			BlockPos neighbor = neighbors.get(i);
			if (!PathUtils.isSafe(neighbor, gameInfo)
					|| !PathUtils.isSafe(neighbor.add(0, 1, 0), gameInfo)
					|| Math.abs(playerPos.getX() - neighbor.getX()) > 256
					|| Math.abs(playerPos.getZ() - neighbor.getZ()) > 256)
				neighbors.remove(i);
			else if (!PathUtils.isFlyable(neighbor, gameInfo))
				if (!PathUtils.isFallable(neighbor, gameInfo))
					neighbors.remove(i);
				else if (!gameInfo.isSolid(pos.add(0, -1, 0)))
					if (!gameInfo.isSolid(neighbor.add(0, -1, 0)))
						neighbors.remove(i);
					else if (previous == null
							|| gameInfo.isSolid(previous.getPos().add(0, -1, 0))
							&& previous.getPos().getY() >= pos.getY())
						neighbors.remove(i);
		}
		neighbors.add(pos.add(0, -1, 0));// down
		if (PathUtils.isFlyable(pos, gameInfo) || PathUtils.isClimbable(pos, gameInfo))
			neighbors.add(pos.add(0, 1, 0));// up
		return neighbors;
	}

	public BlockPos getPos() {
		return pos;
	}

	public PathPoint getPrevious() {
		return previous;
	}

	public int getPriority() {
		return priority;
	}

	public int getMovementCost() {
		return movementCost;
	}
}
