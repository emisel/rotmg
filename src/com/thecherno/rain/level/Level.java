package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;

public class Level {
	protected int width,height;
	protected int [] tiles;
	
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

	protected void generateLevel() {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		
	}
	
	private void time(){
		
	}
	
	public void render(int xscroll, int yscroll, Screen screen) {
		//corner pins
		int x0 = xscroll >> 4;
		int x1 = (xscroll + screen.width) >> 4;
		int y0 = yscroll >> 4;
		int y1 = (yscroll + screen.width) >> 4;
	}

}
