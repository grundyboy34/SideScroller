package com.grundyboy34.utils;

import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ResourceManager {
	private HashMap<String, String> entities = new HashMap<String, String>();
	private HashMap<String, String> obstacles = new HashMap<String, String>();
	private HashMap<String, String> grids = new HashMap<String, String>();
	private String levelPath;
	
	public ResourceManager(String levelPath) {
		this.levelPath = levelPath;
		loadResources();
	}
	
	public void loadResources() {		
		loadFilesToHashMap(entities, new File(levelPath + "/entity/"));
		loadFilesToHashMap(obstacles, new File(levelPath + "/obstacle/"));
		loadFilesToHashMap(grids, new File(levelPath + "/grid/"));			
	}
	
	public Image getEntity(String name) {
		try {
			return new Image(entities.get(name));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getEntityImagePath(String name) {
		return entities.get(name);
	}
	
	
	public Image getObstacle(String name) {
		try {
			return new Image(obstacles.get(name));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Image getGrid(String name) {
		try {
			return new Image(grids.get(name));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void loadFilesToHashMap(HashMap<String, String> map, File dir) {
		for (File f : dir.listFiles()) {
			if (!f.isDirectory()) {
				map.put(getFileNameNoExt(f.getName()), f.getAbsolutePath());
			}
		}
	}
	
	private String getFileNameNoExt(String name) {
		return name.substring(0, name.lastIndexOf('.'));
	}
}
