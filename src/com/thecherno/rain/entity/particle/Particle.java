package com.thecherno.rain.entity.particle;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {
	
	private Sprite sprite;
	
	private int life;
	private int time = 0;
	
	protected double xa, ya, za;
	protected double xx,yy, zz;
	
	public Particle(int x,int y,int life) {
		this.x = x;
		this.y = y;
		
		this.xx = x;
		this.yy = y;
		this.zz = 20.0;
		
		this.life = life + (random.nextInt(50) - 10);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();	
	}
	

	
	public void update(){
		time++;
		if (time >= 7400) time = 0;
		if (time >= life) remove();
		za -= 0.1;
		
		if (zz < 0) {
			zz = 0;
			//change direction slowdown
			za *= -0.6;
			
			//slow down
			xa *= 0.5;
			ya *= 0.5;
			
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int)zz, sprite, true);
	}
}
