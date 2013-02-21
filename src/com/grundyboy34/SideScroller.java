package com.grundyboy34;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.entities.Player;
import com.grundyboy34.utils.LevelDataLoader;
import com.grundyboy34.utils.ResourceManager;

public class SideScroller extends BasicGame {
	private static GameContainer gameContainer;
	private static World world;
	private static ResourceManager resourceManager;
	private static Player player;
	private static Camera camera;
	private final static String levelsDirectory = "levels/default/";
	
	public SideScroller() {
		super("SideScroller Test");
	}
	
	public static GameContainer getGameContainer() {
		return gameContainer;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		try {
			new LevelDataLoader(levelsDirectory + "/1/grids/layout.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameContainer = gc;
		gc.setShowFPS(false);
		gc.setMinimumLogicUpdateInterval(15);
		resourceManager = new ResourceManager();
		world = new World(new Image("levels/1/grids/background.png"), new Vector2f(1280f, 720f));
		player = new Player(500, 250, new Image("levels/1/entities/player.png"), 120);
		world.addEntity(player);
		camera = new Camera(world, player);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		world.update(gc, delta);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		world.render(gc, g, camera);
	}
	
	public World getWorld() {
		return world;
	}
	
	public ResourceManager getResourceManager() {
		return resourceManager;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public static String getLevelsDirectory() {
		return levelsDirectory;
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SideScroller());
		app.setDisplayMode(1280, 720, false);
		app.start();
	}

}
