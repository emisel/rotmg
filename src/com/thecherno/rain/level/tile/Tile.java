package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.spawnlevel.SpawnFloorTile;
import com.thecherno.rain.level.tile.spawnlevel.SpawnGrassTile;
import com.thecherno.rain.level.tile.spawnlevel.SpawnHedgeTile;
import com.thecherno.rain.level.tile.spawnlevel.SpawnWallTile;
import com.thecherno.rain.level.tile.spawnlevel.SpawnWaterTile;

public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	
	public static final int colgrass = 0xFF00FF00;
	public static final int colhedge = 0;
	public static final int colwall1 = 0xFF7e837e;
	public static final int colwall2 = 0xFF000000;
	public static final int colfloor = 0xFF6b4e16;
	public static final int colwater = 0xFF00FF00;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}

}
