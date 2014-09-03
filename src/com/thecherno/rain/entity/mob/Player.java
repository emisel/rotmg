package com.thecherno.rain.entity.mob;

import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {
	private Keyboard input;
	
	public Player(Keyboard input){
		this.input = input;
	}
	public Player(int x, int y ){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		if (input.right) x++;
		if (input.left)  x--;
		if (input.down)  y++;
		if (input.up)  y--;
	}
	
	public void render(){
		
	}

}
