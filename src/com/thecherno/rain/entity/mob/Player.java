package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
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
		int xa = 0, ya = 0;
		if (input.right) xa++;
		if (input.left) xa--;
		if (input.down) ya++;
		if (input.up) ya--;
		
		if (xa != 0 || ya != 0) move(xa, ya);
				
				
	}
	
	public void render(Screen screen){
		int xx = x - 16;
		int yy = y - 16;
		screen.renderPlayer(xx, yy, Sprite.player0);
		screen.renderPlayer(xx+16, yy, Sprite.player1);
		screen.renderPlayer(xx, yy+16, Sprite.player2);
		screen.renderPlayer(xx+16, yy+16, Sprite.player3);
		
	}

}
