package com.grundyboy34;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.entities.Player;
import com.grundyboy34.level.Level;
import com.grundyboy34.utils.LevelDataLoader;
import com.grundyboy34.utils.ResourceManager;

public class SideScroller extends BasicGame {
	private static GameContainer gameContainer;
	private static World world;
	private static Menu menu;
	private final static String levelsDirectory = "levels/";
	
	public SideScroller() {
		super("SideScroller Test");
		
	}
	
	public static GameContainer getGameContainer() {
		return gameContainer;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {	
		gameContainer = gc;
		gc.setShowFPS(false);
		gc.setMinimumLogicUpdateInterval(15);
		menu = new Menu();
		world = new World();
		LevelDataLoader.loadLevels();
		world.setCurrentLevel(1);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		world.update(gc, delta);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		world.render(gc, g);
	}
	
	public static World getWorld() {
		if (world == null)
			System.out.println("WTF");
		return world;
	}
	
	public static String getLevelsDirectory() {
		return levelsDirectory;
	}
	
	public static Vector2f getSize() {
		return new Vector2f(gameContainer.getWidth(), gameContainer.getHeight());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SideScroller());
		app.setDisplayMode(1280, 720, false);
		app.start();
	}

}
