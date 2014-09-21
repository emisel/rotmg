package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
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

	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		if (level.getTile((x+xa)/16, (y+ya)/16).solid()) solid = true;
		return solid;
	}
	public void render(){
		
	}
}
