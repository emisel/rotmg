package com.thecherno.rain.level;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.particle.Particle;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width,height;
	protected int [] tilesInt;
	protected int [] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();

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
	
	public void add(Particle p) {
		p.init(this);
		particles.add(p);
	}
	public void add(Projectile p) {
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
		for (int i = 0;i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();

	}

	private void time(){

	}
	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public boolean tileCollision(int x, int y, int size,int xOffset, int yOffset) {

		boolean solid = false;

		for (int c = 0; c < 4; c++){
			int xt = (x - c % 2 *  1 - 4) >> 4;
			int yt = (y - c / 2 * 1 - 5) >> 4;
            //xt = x; yt = y;  
			if (getTile(xt, yt).solid()) {
				System.out.println("collisison @ xtyt " + xt + ":" +  yt + " xy " + x  +": " + y);
				solid = true;
			}
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
		for (int i = 0;i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
	}
	
	private void remove() {
		for (int i = 0;i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i = 0;i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for (int i = 0;i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) particles.remove(i);
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
