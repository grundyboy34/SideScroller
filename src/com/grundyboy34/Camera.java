package com.grundyboy34;

import com.grundyboy34.entities.Player;

public class Camera {
	private final Player player;
	
	public Camera(Player player) {
		this.player = player;
	}
	
	public float getX() {
		float x = player.getPosition().getX() - (SideScroller.getGameContainer().getWidth() / 2);
		
		if (x < 0) {
			x = 0;
		} else if (x > SideScroller.getGameContainer().getWidth()) {
			x = SideScroller.getGameContainer().getWidth();
		}
		
		return x;
	}	

	public float getY() {
		return player.getPosition().getY();
	}

}
