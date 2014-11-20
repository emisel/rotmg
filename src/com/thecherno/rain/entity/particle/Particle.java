package com.thecherno.rain.entity.particle;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {
	
	private Sprite sprite;
	
	private int life;
	private int time = 0;
	
	protected double xa, ya,xx,yy;
	
	public Particle(int x,int y,int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(50) - 10);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();	
	}
	

	
	public void update(){
		time++;
		if (time >= 7400) time = 0;
		if (time >= life) remove();
		
		this.xx += xa;
		this.yy += ya;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, sprite, true);
	}
}
