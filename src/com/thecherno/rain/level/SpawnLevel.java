package com.thecherno.rain.level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thecherno.rain.level.tile.Tile;

public class SpawnLevel extends Level {


	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path){
		BufferedImage img;
		try {
			img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			tiles = new int[w * h];
			img.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load level");
		}
	}
	
	//grass 0xFF00FF00
	//rock 0xFF7F7F00
	//flower 0xFFFFFF00
	protected void generateLevel() {

	}
}
