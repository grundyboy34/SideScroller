package com.grundyboy34;

import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.grundyboy34.entities.Entity;
import com.grundyboy34.entities.Player;

public class World {
	private final CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	private final Vector2f size;
	private final Image background;
	
	public World(Image background, Vector2f size) {
		this.background = background;
		this.size = size;
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}
	
	public Vector2f getSize() {
		return size;
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public Entity getEntity(int index) {
		return entities.get(index);
	}
	
	public void updateEntities(GameContainer gc, int delta) {
		for (Entity e : entities) {
			e.update(gc, delta);
		}
	}

	public void render(GameContainer gc, Graphics g, Camera camera) {
		background.draw(-camera.getX(), 0);
		for (Entity e : entities) {
			e.render(camera);
		}		
	}

	public void update(GameContainer gc, int delta) {
		updateEntities(gc, delta);
	}
	
	
	
}
