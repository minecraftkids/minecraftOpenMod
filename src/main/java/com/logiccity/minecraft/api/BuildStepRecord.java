package com.logiccity.minecraft.api;

public class BuildStepRecord {

	public PosInt blockPos;
	public Offset offset;
	public PlayerLoc playerLoc;
	public int placeDir;
	public int currentItem;
	public int facing;
	String itemName;
	public String blockAction = null;
	public float playerPitch;
	public float playerYaw;
	
	@Override
	public String toString() {
		return "blockPos:" + blockPos + "; placeDir:" + placeDir + "; playerLoc:" + playerLoc
				+ "; currentItem:" + currentItem + "; playerPitch:" + playerPitch + "; playerYaw:" + playerYaw + "; offset:" + offset;
	}
	
	public static class PosInt {
		public int x;
		public int y;
		public int z;
		@Override
		public String toString() {
			return "(" + x + "," + y + "," + z + ")";
		}
	}
	public static class PlayerLoc {
		public double x;
		public double y;
		public double z;
		@Override
		public String toString() {
			return "(" + x + "," + y + "," + z + ")";
		}
	}
	
	public static class Offset {
		public float x;
		public float y;
		public float z;
		@Override
		public String toString() {
			return "(" + x + "," + y + "," + z + ")";
		}
	}
}