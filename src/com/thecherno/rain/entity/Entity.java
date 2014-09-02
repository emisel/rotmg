package com.thecherno.rain.entity;

import java.util.Random;

import com.thecherno.rain.level.Level;

public abstract class Entity {

	private int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public void render (){
		
	}
	
	public void remove() {
		//Remove from level
		removed = false;
	}
	public boolean isRemoved(){
		return removed;
	} 
}