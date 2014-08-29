package com.thecherno.rain.graphics;

import java.util.Random;

public class Screen {
	private int width, height;
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
	
	public void render(int xoffset,int yoffset){
		
		for (int y = 0; y < height; y++) {
			int yy = y+yoffset;
			//if (yy < height && yy >= 0) {
			for (int x = 0; x < width; x++) {
				int xx = x+xoffset;
				//if (xx < width && xx >= 0) {
				  int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				  pixels[x + y * width] = tiles[tileIndex];
				  pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
				//}
			//}
			}
		}
	}
}
