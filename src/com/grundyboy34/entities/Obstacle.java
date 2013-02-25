package com.grundyboy34.entities;

import org.newdawn.slick.GameContainer;
import com.grundyboy34.level.Level;

public class Obstacle extends Entity {

	public Obstacle(float x, float y, String image, float weight) {
		super(x, y, image, weight);
	}

	@Override
	public void update(GameContainer gc, int delta, Level level) {
		move(level);
	}

}
