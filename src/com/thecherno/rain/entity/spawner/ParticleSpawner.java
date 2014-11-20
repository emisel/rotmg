package com.thecherno.rain.entity.spawner;

import com.thecherno.rain.entity.particle.Particle;
import com.thecherno.rain.level.Level;

public class ParticleSpawner extends Spawner {
	
	private int life;
	
	public ParticleSpawner(int x,int y, int amount,int life,Level level){
		super(x,y,amount,level);
		this.life = life;
		for (int i = 0; i < amount; i++) {
				level.add(new Particle(x,y,life));
			}
	}

}
