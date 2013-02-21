package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Player extends Entity {

	public Player(float x, float y, Image image, float weight) {
		super(x, y, image, weight);
	}

	@Override
	public void update(GameContainer gc, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			velocity.x -= runSpeed;
		} else if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			velocity.x += runSpeed;
		} 
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			jump = true;
		}
		move();	
	}
	
	
	@Override
	public void move() {
		super.move();
		
		
	}


}
