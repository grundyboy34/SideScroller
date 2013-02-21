package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.SideScroller;

abstract public class Entity {
	private Vector2f velocity = new Vector2f();
	private Image image;
	private Rectangle container;
	private final float runSpeed = 5f;
	private final float jumpSpeed = 8f;
	private final float gravity = .6f;
	private final float friction = .35f;
	
	protected boolean jump = false;
	protected boolean jumpLockOut = false;
	
	public Entity(float x, float y, Image image) {
		this.image = image;	
		container = new Rectangle(x, y, image.getWidth(), image.getHeight());
		
	}
	
	protected void move() {
		
		velocity.y += gravity;
		
		if (!jumpLockOut && jump) {
			velocity.y -= jumpSpeed;
			jumpLockOut = true;
		}
	
		float newX = container.getX() + velocity.getX();
		float newY = container.getY() + velocity.getY();
		float lowerBoundary = SideScroller.getGameContainer().getHeight();
		
		if (newY > lowerBoundary) {
			newY = lowerBoundary;
			velocity.y = 0f;
			if (jump) {
				jumpLockOut = false;
				jump = false;
			}
		}
		
		container.setLocation(newX, newY);
		
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}
	
	public Rectangle getPosition() {
		return container;
	}
	
	public void draw() {
		image.draw(container.getX() - image.getWidth(), container.getY() - image.getHeight());
	}

	abstract public void update(GameContainer gc, int delta);

}
