package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import com.grundyboy34.Camera;
import com.grundyboy34.SideScroller;
import com.grundyboy34.level.Level;

public class Player extends Entity {
	
	public Player(float x, float y, float weight) {
		super(x, y, "player", weight);
	}

	public Player(float x, float y, String image, float weight) {
		super(x, y, image, weight);
	}
	

	@Override
	public void update(GameContainer gc, int delta, Level level) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			velocity.x -= runSpeed;
		} else if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			velocity.x += runSpeed;
		} 
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			jump = true;
		}
		
		if (input.isKeyDown(Input.KEY_Z)) {
			SideScroller.getWorld().setCurrentLevel(0);
		} else if (input.isKeyDown(Input.KEY_X)) {
			SideScroller.getWorld().setCurrentLevel(1);
		}
		move(level);	
	}
	
	
	@Override
	public void render(Level level) {
			currentImage.draw(container.getX() - level.getCamera().getX(), container.getY() - currentImage.getHeight());
	}
}
