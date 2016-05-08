package com.logiccity.minecraft.api.command;

import com.logiccity.minecraft.api.impl.CustomModCommandBase;

public class BowAim extends CustomModCommandBase {
	private BowAim() {
		super("AutoBow", "Y");
	}

	private String target = null, tmpTarget = null;
	private float velocity;

	@Override
	public boolean doInRenderTicThread() {
		if (tmpTarget != null) {
			gameControl.renderHighlightEntity(tmpTarget, 1);
		}
		return false;
	}

	@Override
	public void cleanupCmd() {
		target = tmpTarget = null;
		gameControl.setPreventClientClick(false);
		gameControl.stopSendingPackagesToServer(null);
	}

	@Override
	public boolean doInUpdateTicThread() {
		if ("bow".equals(gameInfo.holdingItemUnlocalizedName(null))) {
			if (gameInfo.isKeyUseItemPressed()) {
				gameControl.stopSendingPackagesToServer("1");
				tmpTarget = gameInfo.getClosestFacingAngleEntity();
				return false;
			}
			gameControl.stopSendingPackagesToServer(null);
			gameControl.setPreventClientClick(true);
			if (tmpTarget != null) {
				target = tmpTarget;
			} else {
				target = tmpTarget = null;
				return false;
			}
			if (gameInfo.getLivingEntityHealth(target) <= 0) {
				target = tmpTarget = null;
				return false;
			}

			aimAtTarget();
			
			if (gameInfo.isKeyAttackPressed()) {
				fireArrow();
				gameControl.setPreventClientClick(false);
			}
//			fireArrow();
		} else {
			target = tmpTarget = null;
		}
		return false;
	}
	
	private final void fireArrow() {
		if ((! "bow".equals(gameInfo.holdingItemUnlocalizedName(null)))
				|| target == null || gameInfo.getLivingEntityHealth(target) <= 0) {
			target = tmpTarget = null;
			return;
		}
		gameControl.simulateUseItemKeyPress();
		for (int i = 0; i < 20; i++) {
			gameControl.simulateTimeUnitPassed();
		}
		gameControl.simulateUseItemKeyRelease();
	}

	private void aimAtTarget() {
		if (target == null) {
			return;
		}
		gameControl.pointArrowAt(target);
	}

	@Override
	protected boolean handleCmdInput(String input) {
		if (this.getKeyChar()== input.charAt(0)) {
			fireArrow();
			return false;
		} else {
			return super.handleCmdInput(input);
		}
	}
}
