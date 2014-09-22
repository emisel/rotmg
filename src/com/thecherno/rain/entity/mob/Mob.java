package com.thecherno.rain.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.projectile.MonsterProjectile;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	private List<Projectile> shoots = new ArrayList<Projectile>();
	
	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa,0);
			move(0,ya);
			return;
		}
			
		if (xa > 0) dir = 1; //east
		if (xa < 0) dir = 3; //west
		if (ya > 0) dir = 2; //south
		if (ya < 0) dir = 0; //north
		
		if (!collision(xa,ya)) {
			x += xa;
			y += ya;
		}
	}
	
	public void update(){
		
	}
	
	protected void shoot(int x,int y, double dir){
		Projectile p = new MonsterProjectile(x, y, dir);
		shoots.add(p);
		level.add(p);
	}

	
	private boolean collision(int xa, int ya) {
		
		boolean solid = false;
		
		for (int c = 0; c<4; c++){
			int xt = ((x+xa) + c % 2 * 14 -5) / 16;
			int yt = ((y+ya) + c / 2 * 12-0) / 16;
			
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		
		
		return solid;
	}
	public void render(){
		
	}
}
