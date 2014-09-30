package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class MonsterProjectile extends Projectile {

	
	public MonsterProjectile(int x, int y, double dir) {
		super(x,y,dir);
		damage = 200;
		rateOfFire = 5;
		speed = 5;
		damage = 20;
		sprite = Sprite.projectile;
		range = 100;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen) {
		screen.renderProjectile(x, y, this);
	}

}
