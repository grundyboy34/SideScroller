package com.grundyboy34.level;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.Camera;
import com.grundyboy34.entities.Player;
import com.grundyboy34.utils.ResourceManager;

public class Level {
	private String name;
	private ArrayList<Grid> gridlist = new ArrayList<Grid>();
	private transient Grid currentGrid;
	private transient Player player;
	private transient Camera camera;
	private transient ResourceManager resourceManager;
	
	
	public Level(String name) {
		this.name = name;
		init();
	}
	
	public void init() {
		this.player = new Player(0, 0, 65);
		player.init(this);
		this.camera = new Camera(player);
		setCurrentGrid(0);
	}
	
	public Grid getNextGrid() {
		return gridlist.get(gridlist.indexOf(currentGrid) + 1);
	}
	
	public Grid getLastGrid() {
		return gridlist.get(gridlist.indexOf(currentGrid) - 1);
	}
	
	public void setCurrentGrid(int index) {
		setCurrentGrid(gridlist.get(index));
	}
	
	
	public void setCurrentGrid(Grid grid) {
		grid.init(this);
		currentGrid = grid;
	}
	
	public Vector2f getSize() {
		Image img = getResourceManager().getGrid(currentGrid.getBackground());
		return new Vector2f(img.getWidth(), img.getHeight());
	}
	
	public String getName() {
		return name;
	}
	
	public void addGrid(Grid grid) {
		gridlist.add(grid);
	}
	
	public void addGrid(Grid grid, int index) {
		gridlist.add(index, grid);
	}
	
	public ArrayList<Grid> getGridList() {
		return gridlist;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	
	public ResourceManager getResourceManager() {
		return resourceManager;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void update(GameContainer gc, int delta) {
		currentGrid.update(gc, delta, this);
		player.update(gc, delta, this);
		if (player.getPosition().getX() > getSize().getX()) {
			setCurrentGrid(getNextGrid());
			player.getPosition().setX(0);
		} else if (player.getPosition().getX() < -80) {
			setCurrentGrid(getLastGrid());
			player.getPosition().setX(getSize().getX());
		}
	}

	public void render(GameContainer gc, Graphics g) {
		currentGrid.render(gc, g, this);
		player.render(this);
	}
}
