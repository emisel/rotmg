package com.thecherno.rain.level;

public class TileCoordinate {
	private int x;
	private int y;
	private int [] coordinates = new int[2];
	
	
	private static final int TILE_SIZE = 16;
	
	public TileCoordinate(int x, int y){
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
	public int x(){
		return x;
	}
	public int y(){
		return y;
	}
	
	public int [] getCoordinates(){
		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}
}
