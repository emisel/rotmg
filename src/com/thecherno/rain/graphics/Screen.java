package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.level.tile.Tile;

public class Screen {
	public int width;
	private int height;
	private static final int MAP_SIZE = 128;
	private static final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int pixels[];
	public int tiles[];
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		tiles = new int[MAP_SIZE * MAP_SIZE];
		
		for (int i = 0; i< MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		tiles[0] = 0x00;
	}
	public void clear(){
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset,int yOffset){
		
		for (int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if (yp < 0 || yp >= height) continue;
			
			for (int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				  pixels[xp + yp * width] = Sprite.voidSprite.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
			}
		}
	}
	
	public void renderTile(int xp, int yp,Tile tile){
		for (int y = 0; y< tile.sprite.SIZE; y++) {
			//absolute pos
			int ya = y + yp;
			for (int x = 0; x< tile.sprite.SIZE; x++) {
				//absolute pos
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) break;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
}
