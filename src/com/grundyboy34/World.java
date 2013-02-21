package com.grundyboy34;

import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.GameContainer;

import com.grundyboy34.entities.Entity;

public class World {
	private static CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}
	
	public static void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public Entity getEntity(int index) {
		return entities.get(index);
	}
	
	public static void drawEntities() {
		for (Entity e : entities) {
			e.draw();
		}
	}

	public static void updateEntities(GameContainer gc, int delta) {
		for (Entity e : entities) {
			e.update(gc, delta);
		}
	}
	
	
}
