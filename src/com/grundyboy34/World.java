package com.grundyboy34;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import com.grundyboy34.level.Level;

public class World {
	private final ArrayList<Level> levelList = new ArrayList<Level>();
	private static Level currentLevel = null;
	//private final Image background;
	
	public World() {
		//this.background = background;
		//this.size = size;
	}
	
	public void setCurrentLevel(int index) {
			setCurrentLevel(levelList.get(index));	
	}
	
	public void setCurrentLevel(Level level) {
		level.init();
		currentLevel = level;
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}

	public ArrayList<Level> getLevels() {
		return levelList;
	}
	
	public void addLevel(Level level) {
		levelList.add(level);
		if (currentLevel == null) {
			setCurrentLevel(0);
		}
	}
	
	

	public void render(GameContainer gc, Graphics g) {
		currentLevel.render(gc, g);
	}

	public void update(GameContainer gc, int delta) {
		currentLevel.update(gc, delta);
	}
	
	
	
}
