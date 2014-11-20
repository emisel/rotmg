package com.thecherno.rain.entity.spawner;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.particle.Particle;
import com.thecherno.rain.level.Level;

public class Spawner extends Entity {
	
	
	
	public Spawner(int x, int y, int amount, Level level) {
			this.x = x;
			this.y= y;
			this.level = level;
		
			
	}
}
