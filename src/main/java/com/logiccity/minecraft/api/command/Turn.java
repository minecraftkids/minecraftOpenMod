package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;
import com.logiccity.minecraft.api.util.MathUtils;

public class Turn extends CustomModCommandBase {
	public static final int getAxisesYaw(float yaw) {
		yaw = MathUtils.normalYaw(yaw);
		int yawI;
		if (yaw > -45 && yaw <= 45 ) {
			yawI = 0;
		} else if (yaw > 45 && yaw <=135) {
			yawI = 90;
		} else if (yaw > -135 && yaw <= -45) {
			yawI = -90;
		} else {
			yawI = 180;
		}
		return yawI;
	}
	
	private Turn() {
		super("turn", 1, 2);
	}

	private float intendedY, intendedP;
	@Override
	public void initCmd(String[] args) {
		intendedY = MathUtils.normalYaw(Float.parseFloat(args[0]));
		if (args.length > 1) {
			intendedP = Float.parseFloat(args[1]);
		} else {
			intendedP = Integer.MIN_VALUE;
		}
	}

	@Override
	public boolean doInUpdateTicThread() {
		if (intendedP != Integer.MIN_VALUE) {
			gameControl.setRotationPitch(intendedP);
			intendedP = Integer.MIN_VALUE;
		}
		if (gameInfo.getRotationYaw() == intendedY) {
			return true;
		}
		safeTurn(intendedY);
		return false;
	}

	private static final float maxChange = 55;
	public final void safeTurn(float intent) {
		
		final float pre = gameInfo.getPreviousRotationYaw();
		if (pre == intent) {
			return;
		}
		if (pre < intent) {
			if (intent - pre > 180) {
				float tmp = pre - maxChange;
				if (tmp < -180) {
					tmp += 360;
				}
				if (tmp < intent) {
					gameControl.setRotationYaw(intent);
				} else {
					gameControl.setRotationYaw(tmp);
				}
			} else {
				float tmp = pre + maxChange;
				if (tmp > intent) {
					gameControl.setRotationYaw(intent);
				} else {
					gameControl.setRotationYaw(tmp);
				}
			}
		} else { //pre > intent
			if (pre - intent > 180) {
				float tmp = pre + maxChange;
				if (tmp > 180) {
					tmp -= 360;
				}
				if (tmp > intent) {
					gameControl.setRotationYaw(intent);
				} else {
					gameControl.setRotationYaw(tmp);
				}
			} else {
				float tmp = pre - maxChange;
				if (tmp < intent) {
					gameControl.setRotationYaw(intent);
				} else {
					gameControl.setRotationYaw(tmp);
				}
			}
		}
	}
}
