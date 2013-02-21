package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.Camera;
import com.grundyboy34.SideScroller;
import com.grundyboy34.physics.Physics;

abstract public class Entity {
	protected Image originalImage, flippedImage, currentImage;
	protected Rectangle container;
	protected Vector2f velocity = new Vector2f();
	protected final float runSpeed = 50f;
	protected final float jumpSpeed = 15f;
	protected final float gravity = .98f;
	protected final float weight;
	
	protected boolean jump = false;
	protected boolean jumpLockOut = false;
	
	public Entity(float x, float y, Image image, float weight) {
		this.originalImage = image;	
		this.flippedImage = image.getFlippedCopy(true, false);
		this.weight = weight;
		this.container = new Rectangle(x, y, image.getWidth(), image.getHeight());
		currentImage = originalImage;
		
	}
	
	
	protected void move() {
		
		velocity.y += gravity;
		
		velocity.x /= Math.sqrt(Physics.getFrictionalForce(Physics.calculateNormalForce(weight), .35f));
		
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
		if (newX > container.getX()) {
			currentImage = flippedImage;
		} else if (newX < container.getX()){
			currentImage = originalImage;
		}
		
		container.setLocation(newX, newY);
		
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}
	
	public Rectangle getPosition() {
		return container;
	}
	
	public void render(Camera camera) {
		currentImage.draw(container.getX() - camera.getX(), container.getY() - currentImage.getHeight());
	}

	abstract public void update(GameContainer gc, int delta);

}
