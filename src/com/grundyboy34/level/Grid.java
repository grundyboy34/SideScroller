package com.grundyboy34.level;

import java.util.ArrayList;

import com.grundyboy34.entities.Mob;
import com.grundyboy34.entities.Obstacle;

public class Grid {
	private String background;
	private ArrayList<Mob> enemies = new ArrayList<Mob>();
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public Grid(String background) {
		this.background = background;
	}

}
