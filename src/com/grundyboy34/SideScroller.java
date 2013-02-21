package com.grundyboy34;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.grundyboy34.entities.Mob;

public class SideScroller extends BasicGame {
	private Image background = null;
	private static GameContainer gameContainer;

	public SideScroller() {
		super("SideScroller Test");
	}
	
	public static GameContainer getGameContainer() {
		return gameContainer;
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		gameContainer = gc;
		gc.setMinimumLogicUpdateInterval(15);
		background = new Image("res/background.png");
		World.addEntity(new Mob(500, 250, new Image("res/robot.png")));
	
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		World.updateEntities(gc, delta);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < 30; i++) {
			background.draw(i * gc.getWidth(), 0);
		}
		World.drawEntities();
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SideScroller());
		app.setDisplayMode(1280, 720, false);
		app.start();
	}

}
