package com.thecherno.rain.level;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width,height;
	protected int [] tilesInt;
	protected int [] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public static Level spawn = new SpawnLevel("/levels/spawnlevel.png");

	public Level (int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
		// TODO Auto-generated method stub

	}
	public void add(Entity e) {
		e.init(this);
		entities.add(e);
	}
	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}

	protected void generateLevel() {
		// TODO Auto-generated method stub

	}

	public void update() {
		for (int i = 0;i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0;i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}

	}

	private void time(){

	}
	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public boolean tileCollision(double x, double y,double xa, double ya, int size) {

		boolean solid = false;

		for (int c = 0; c<4; c++){
			int xt = (((int)x+(int)xa) + c % 2 *  - 10 ) / 16;
			int yt = (((int)y+(int)ya) + c / 2 * 2- 6) / 16;

			if (getTile(xt, yt).solid()) solid = true;
		}


		return solid;
	}

	public void render(int xscroll, int yscroll, Screen screen) {

		screen.setOffset(xscroll, yscroll);
		//corner pins
		int x0 = xscroll >> 4;
		int x1 = (xscroll + screen.width + 16) >> 4;
		int y0 = yscroll >> 4;
		int y1 = (yscroll + screen.width) >> 4;


		for (int y = y0; y < y1; y++){
			for (int x= x0 ; x < x1; x++){
				getTile(x,y).render(x, y, screen);

			}
		}
		for (int i = 0;i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0;i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.colgrass) return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.colhedge) return Tile.spawn_hedge;
		if (tiles[x + y * width] == Tile.colfloor) return Tile.spawn_floor;
		if (tiles[x + y * width] == Tile.colwall1) return Tile.spawn_wall1;
		if (tiles[x + y * width] == Tile.colwall2) return Tile.spawn_wall2;
		if (tiles[x + y * width] == Tile.colwater) return Tile.spawn_water;
		return Tile.voidTile;
	}

}
