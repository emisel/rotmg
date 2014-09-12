package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected Tile tiles [];
	protected int width,height;
	protected int [] tilesInt;

	public Level (int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path){
		loadLevel(path);
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
				if (x < 0 || y < 0 || y >= height || x >= width) Tile.voidTile.render(x, y, screen) ;

				else {
					tiles[x + y * 16].render(x, y, screen);
				}
			}
		}
	}

	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		if (tilesInt[x + y * width] == 0) return Tile.grass;
		if (tilesInt[x + y * width] == 1) return Tile.rock;
		if (tilesInt[x + y * width] == 2) return Tile.flower;
		return Tile.voidTile;
	}

}
