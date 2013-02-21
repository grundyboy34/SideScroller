package com.grundyboy34.physics;

public class Physics {
	private final static float gravity = 9.80f;
	
	public static float calculateNormalForce(float mass) {
		return mass * gravity;
	}
	
	public static float getFrictionalForce(float normalForce, float frictionalCoefficient) {		
		return normalForce * frictionalCoefficient;
	}
}
