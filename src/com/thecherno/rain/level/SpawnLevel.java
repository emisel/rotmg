package com.thecherno.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thecherno.rain.level.tile.Tile;

public class SpawnLevel extends Level {

	private Tile tiles[];
	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path){
		BufferedImage img;
		try {
			img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			tiles = new Tile[w * h];
			img.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load level");
		}
	}
	
	//grass 0xFF0000
	//rock 0xFF0000
	//flower 0xFF0000
	protected void generateLevel() {
		
		
	}
}
