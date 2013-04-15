package com.grundyboy34.physics;

import com.grundyboy34.SideScroller;

public class Physics {
	public final static float gravity = 9.80f;
	
	public static float calculateNormalForce(float mass) {
		return mass * gravity;
	}
	
	public static float getFrictionalForce(float normalForce, float frictionalCoefficient) {		
		return normalForce * frictionalCoefficient;
	}
	
	public static float getMeterMultiplier() {
		return 20f / (float) SideScroller.getGameContainer().getHeight();
	}
}
