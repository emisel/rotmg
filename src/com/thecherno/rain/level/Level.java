package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;

public class Level {
	private int width,height;
	private int [] tiles;
	
	public Level (int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
	}

	private void loadLevel(String path) {
		// TODO Auto-generated method stub
		
	}

	private void generateLevel() {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		
	}
	
	private void time(){
		
	}
	
	public void render(int xscroll, int yscroll, Screen screen) {
		
	}

}
