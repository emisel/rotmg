package com.thecherno.rain.graphics;

public class Screen {
	private int width, height;
	public int pixels[];
	int counter = 0;
	int xtime = 50,ytime = 100;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	public void clear(){
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(){
		counter++;
		if (counter % 2 == 0) {
			xtime++;
		}
		if (counter % 10 == 0) {
			ytime++;
		}
		for (int y = 0; y < height; y++) {
			if (ytime < height && ytime > 0) {
			for (int x = 0; x < width; x++) {
				if (xtime < width && xtime > 0) {
				  pixels[xtime + ytime * width] = 0xFF00FF;
				}
			}
			}
		}
	}
}
