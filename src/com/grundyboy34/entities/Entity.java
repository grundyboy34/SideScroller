package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

abstract public class Entity {
	private float x, y;
	private Image image = null;
	
	public Entity(float x, float y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	
	public void draw() {
		image.draw(x, y);
	}

	abstract public void update(GameContainer gc, int delta);

}
