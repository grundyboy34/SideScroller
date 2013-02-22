package com.grundyboy34.level;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.Camera;
import com.grundyboy34.SideScroller;
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
		currentGrid = gridlist.get(0);
		currentGrid.init(this);
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

	public void update(GameContainer gc, int delta) {
		currentGrid.update(gc, delta, this);
		player.update(gc, delta, this);
	}

	public void render(GameContainer gc, Graphics g) {
		getResourceManager().getGrid(currentGrid.getBackground()).draw(-camera.getX(), 0);
		currentGrid.render(gc, g, camera, this);
		player.render(camera, this);
	}
}
