package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public class Projectile extends Entity {
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected double x,y;
	protected  Sprite sprite;
	protected double distance;
	protected double nx,ny;
	protected double speed, rateOfFire, range, damage;
	
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	protected void move() {
		
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
