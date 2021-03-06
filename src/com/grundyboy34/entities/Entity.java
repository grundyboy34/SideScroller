package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.Camera;
import com.grundyboy34.SideScroller;
import com.grundyboy34.level.Level;
import com.grundyboy34.physics.Physics;

abstract public class Entity {
	protected String image;
	protected float x, y;
	protected transient Rectangle container;
	protected transient Image currentImage;
	protected transient Vector2f velocity;
	protected final transient float runSpeed = 2000f;
	protected final transient float jumpSpeed = 50f;
	protected float weight;

	protected transient boolean jump = false;
	protected transient boolean jumpLockOut = false;

	public Entity(float x, float y, String image, float weight) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.weight = weight;
		this.container = null;
	}

	public void init(Level level) {
		this.container = new Rectangle(x, y, level.getResourceManager().getEntity(image).getWidth(), 
					level.getResourceManager().getEntity(image).getHeight());
		this.currentImage = level.getResourceManager().getEntity(image);
		velocity = new Vector2f();
		
		System.out.println("inited " + image + " - " + container.getWidth() + " - " + container.getHeight());
	}
	
	public void initObstacle(Level level) {
		this.container = new Rectangle(x, y, level.getResourceManager().getObstacle(image).getWidth(), 
					level.getResourceManager().getObstacle(image).getHeight());
		this.currentImage = level.getResourceManager().getObstacle(image);
		velocity = new Vector2f();
	}

	protected void move(Level level) {
		velocity.y += Physics.gravity;

		velocity.x /= Math.sqrt(Physics.getFrictionalForce(Physics.calculateNormalForce(weight), .35f));

		if (!jumpLockOut && jump) {
			velocity.y -= jumpSpeed;
			jumpLockOut = true;
		}

		float newX = container.getX() + velocity.getX() * Physics.getMeterMultiplier();
		float newY = container.getY() + velocity.getY();

		if (newY > SideScroller.getGameContainer().getHeight()) {
			newY = SideScroller.getGameContainer().getHeight();
			velocity.y = 0f;
			if (jump) {
				jumpLockOut = false;
				jump = false;
			}
		}
		if (newX > container.getX()) {
			currentImage = level.getResourceManager().getEntity(image).getFlippedCopy(true, false);
		} else if (newX < container.getX()) {
			currentImage = level.getResourceManager().getEntity(image);
		}

		container.setLocation(newX, newY);

	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public Rectangle getPosition() {
		return container;
	}

	public void render(Level level) {
		currentImage.draw(container.getX() - level.getCamera().getX(), container.getY() - currentImage.getHeight());
	}

	abstract public void update(GameContainer gc, int delta, Level level);

}
