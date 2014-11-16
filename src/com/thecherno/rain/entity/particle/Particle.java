package com.thecherno.rain.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {
	
	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;
	
	private int life;
	
	protected double xa, ya,xx,yy;
	
	public Particle(int life,int x,int y) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life;
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();	
	}
	
	public Particle(int life,int x,int y,int amount) {
		this(life, x,y);
		for (int i = 0; i < amount -1; i++) {
			particles.add(new Particle(life,x,y));
		}
		particles.add(this);
		
	}
	
	public void update(){
		this.xx += xa;
		this.yy += ya;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, sprite, true);
	}
}
