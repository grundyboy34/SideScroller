package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Mob extends Entity {

	public Mob(float x, float y, Image image) {
		super(x, y, image);
	}

	@Override
	public void update(GameContainer gc, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			
		} else if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			
		} else if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			jump = true;
		}
		move();		
	}

}
