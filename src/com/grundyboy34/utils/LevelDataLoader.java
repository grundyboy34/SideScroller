package com.grundyboy34.utils;

import java.util.ArrayList;

import com.grundyboy34.io.LevelXMLHandler;
import com.grundyboy34.level.Grid;
import com.grundyboy34.level.Level;

public class LevelDataLoader {
	private ArrayList<Level> levelList = new ArrayList<Level>();
	private LevelXMLHandler xmlHander = new LevelXMLHandler();
	
	public LevelDataLoader(String filePath) throws Exception {
		Level testLevel = new Level("TestLevel");
		testLevel.addGrid(new Grid("background"));
		levelList.add(testLevel);
		saveData(filePath);
		//readData(filePath);
	}
	
	private void readData(String file) throws Exception {
	/*	BufferedReader in = new BufferedReader(new FileReader(file));
		while (in.ready()) {
			String line = in.readLine().trim();
			
		}*/
		
		levelList = xmlHander.fromXML(file);
		for (int i = 0; i < levelList.size(); i++) {
			System.out.println(levelList.get(i));
		}
		
	}
	
	private void saveData(String file) throws Exception {
	/*	BufferedReader in = new BufferedReader(new FileReader(file));
		while (in.ready()) {
			String line = in.readLine().trim();
			
		}*/
		
		xmlHander.toXML(file, levelList);
		
	}
	
	

}
