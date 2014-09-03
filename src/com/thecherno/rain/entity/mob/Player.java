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
	
//		screen.renderPlayer(xx, yy, Sprite.player0);
//		screen.renderPlayer(xx+16, yy, Sprite.player1);
//		screen.renderPlayer(xx, yy+16, Sprite.player2);
//		screen.renderPlayer(xx+16, yy+16, Sprite.player3);
//		
		if (dir == 3) sprite = Sprite.player_left;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) sprite = Sprite.player_down;
		if (dir == 0) sprite = Sprite.player_up;
		
		screen.renderPlayer(x-16, y-16, sprite);
	}

}
