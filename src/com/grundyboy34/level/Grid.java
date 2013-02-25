package com.grundyboy34.level;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.grundyboy34.entities.Entity;
import com.grundyboy34.entities.Mob;
import com.grundyboy34.entities.Obstacle;

public class Grid {
	private String background;
	private ArrayList<Mob> enemies = new ArrayList<Mob>();
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public Grid(String background) {
		this.background = background;
	}
	
	public void init(Level level) {
		for (Entity e : enemies) {
			e.init(level);
		}
		
		for (Entity e : obstacles) {
			e.initObstacle(level);
		}
	}

	public void update(GameContainer gc, int delta, Level level) {
		for (Entity e : enemies) {
			e.update(gc, delta, level);
		}	
		for (Entity e : obstacles) {
			e.update(gc, delta, level);
		}	
	}

	public void render(GameContainer gc, Graphics g, Level level) {
			level.getResourceManager().getGrid(getBackground()).draw(-level.getCamera().getX(), 0);
		
		for (Entity e : enemies) {
			e.render(level);
		}	
		
		for (Entity e : obstacles) {
			e.render(level);
		}
	}

	public String getBackground() {
		return background;
	}

}
