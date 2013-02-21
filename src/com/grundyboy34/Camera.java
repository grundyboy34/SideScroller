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
		//return getCurrentGrid() * world.getSize().getX();
		float x = player.getPosition().getX() - (world.getSize().getX() / 2);
		
		if (x < 0) {
			x = 0;
		}
		
		return x;
	}	
	
	public int getCurrentGrid() {
		return (int) (player.getPosition().getX() / world.getSize().getX());			
	}

	public float getY() {
		return player.getPosition().getY();
	}

}
