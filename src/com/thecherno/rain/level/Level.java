package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width,height;
	protected int [] tilesInt;
	protected int [] tiles;
	public static Level spawn = new Level("/levels/spawnlevel.png");

	public Level (int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
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

		screen.setOffset(xscroll, yscroll);
		//corner pins
		int x0 = xscroll >> 4;
		int x1 = (xscroll + screen.width + 16) >> 4;
		int y0 = yscroll >> 4;
		int y1 = (yscroll + screen.width) >> 4;


		for (int y = y0; y < y1; y++){
			for (int x= x0 ; x < x1; x++){
			getTile(x,y).render(x, y, screen);
				
			}
		}
	}

	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		if (tiles[x + y * width] == 0xFF00FF00) return Tile.grass;
		if (tiles[x + y * width] == 0xFF7F7F00) return Tile.rock;
		if (tiles[x + y * width] == 0xFFFFFF00) return Tile.flower;
		return Tile.voidTile;
	}

}
