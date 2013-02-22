package com.grundyboy34;

import com.grundyboy34.entities.Player;

public class Camera {
	private final Player player;
	
	public Camera(Player player) {
		this.player = player;
	}
	
	public float getX() {
		float x = player.getPosition().getX() - (SideScroller.getSize().getX() / 2);
		
		if (x < 0) {
			x = 0;
		}
		
		return x;
	}	
	
	public int getCurrentGrid() {
		return (int) (player.getPosition().getX() / SideScroller.getSize().getX());			
	}

	public float getY() {
		return player.getPosition().getY();
	}

}
