package com.thecherno.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int [] pixels;
	
	public static SpriteSheet sheet = new SpriteSheet("/textures/sheets/sprite_sheet.png", 256);
	public static SpriteSheet spawnLevel = new SpriteSheet("/textures/sheets/spawnlevel.png",48);
	public static SpriteSheet projectiles = new SpriteSheet("/textures/sheets/projectiles/wizard.png",48);
	
	public SpriteSheet(String path,int size){
	
		this.SIZE = size;
		this.path = path;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0,0, w, h, pixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
