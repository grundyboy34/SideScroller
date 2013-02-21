package com.grundyboy34;

import com.grundyboy34.entities.Player;

public class Camera {
	private final World world;
	private final Player player;
	
	public Camera(World world, Player player) {
		this.world = world;
		this.player = player;
	}
	
	public float getX() {
		return player.getPosition().getX();
	}
	
	public float getY() {
		return player.getPosition().getY();
	}

}
