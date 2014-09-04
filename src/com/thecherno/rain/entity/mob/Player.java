package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_up;
	}
	public Player(int x, int y ){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if (input.right) xa++;
		if (input.left) xa--;
		if (input.down) ya++;
		if (input.up) ya--;
		
		if (xa != 0 || ya != 0) move(xa, ya);
				
				
	}
	
	public void render(Screen screen){
		int flip = 0;
		if (dir == 0) sprite = Sprite.player_up;
		if (dir == 1) sprite = Sprite.player_side;
		if (dir == 2) sprite = Sprite.player_down;
		if (dir == 3) {
			flip = 1;
			sprite = Sprite.player_side;
		}
			
		
		screen.renderPlayer(x-16, y- 16, sprite, flip);
	}

}
