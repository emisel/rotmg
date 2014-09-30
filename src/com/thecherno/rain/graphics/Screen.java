package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.level.tile.Tile;

public class Screen {
	public int width;
	private int height;
	private static final int MAP_SIZE = 128;
	private static final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	
	public int xOffset, yOffset;
	
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
	

	
	public void renderTile(int xp, int yp,Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y< tile.sprite.SIZE; y++) {
			//absolute pos
			int ya = y + yp;
			for (int x = 0; x< tile.sprite.SIZE; x++) {
				//absolute pos
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderProjectile(int xp, int yp,Projectile projectile){
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y< projectile.getSprite().SIZE; y++) {
			//absolute pos
			int ya = y + yp;
			for (int x = 0; x< projectile.getSprite().SIZE; x++) {
				//absolute pos
				int xa = x + xp;
				if (xa < -projectile.getSprite().SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = projectile.getSprite().pixels[x + y * projectile.getSprite().SIZE];
				if (col != 0xffff00ff)
				pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderPlayer(int xp, int yp,Sprite sprite, int flip){
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			//absolute pos
			int ya = y + yp;
			int ys = y;
			if (flip == 3 || flip == 2) ys = 31 - y;
			for (int x = 0; x< 32; x++) {
				//absolute pos
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) xs = 31 - x;
				if (xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffff00ff) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
