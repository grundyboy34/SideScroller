package com.grundyboy34.level;

import java.util.ArrayList;

public class Level {
	private String name;
	private ArrayList<Grid> gridlist = new ArrayList<Grid>();
	
	
	public Level(String name) {
		this.name = name;
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
}
