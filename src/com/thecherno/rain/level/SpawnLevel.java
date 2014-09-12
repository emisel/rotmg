package com.thecherno.rain.level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thecherno.rain.level.tile.Tile;

public class SpawnLevel extends Level {

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
			levelPixels = new int[w * h];
			img.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load level");
		}
	}
	
	//grass 0x00FF00
	//rock 0x7F7F00
	//flower 0xFFFF00
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length;i++){
			Color c0 = new Color(levelPixels[i]);
			Color c = new Color(0xFF7F7F00);
			System.out.println(c0.getBlue()+":"+c0.getGreen() + ":" +c0.getRed());
			System.out.println(c.getBlue()+":"+c.getGreen() + ":" +c.getRed());
			if (levelPixels[i] == 0xFF00FF00) tiles[i] = Tile.grass;
			
			if (levelPixels[i] == 0xFF7F7F00) tiles[i] = Tile.rock;
			if (levelPixels[i] == 0xFFFFFF00) tiles[i] = Tile.flower;
		}
		
	}
}
