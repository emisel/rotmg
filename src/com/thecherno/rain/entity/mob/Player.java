package com.thecherno.rain.entity.mob;

import com.thecherno.rain.Game;
import com.thecherno.rain.entity.projectile.MonsterProjectile;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;
import com.thecherno.rain.level.TileCoordinate;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private int animate = 0;
	private boolean walking = false;
	
	private int fireRate = 0;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_up;
	}
	public Player(int x, int y ,Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		fireRate = MonsterProjectile.FIRE_RATE;
		
	}
	public Player(TileCoordinate tc ,Keyboard input){
		this(tc.x(),tc.y(),input);
	}
	
	public void update(){
		if (fireRate > 0) fireRate--; 
		int xa = 0, ya = 0;
		animate++;
		if (animate > 7500) animate = 0;
		if (input.right) xa++;
		if (input.left) xa--;
		if (input.down) ya++;
		if (input.up) ya--;
		
		if (xa != 0 || ya != 0) { 
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
				
		updateShooting();
	}
	
	private void clear() {
			for (int i = 0; i < level.getProjectiles().size(); i++) {
				if(level.getProjectiles().get(i).isRemoved()) {
					level.getProjectiles().remove(i);
				}
			}
	}
	private void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = (Mouse.getX() - Game.getWindowWidth()/2);
			double dy = (Mouse.getY() - Game.getWindowHeight()/2);
			double dir = Math.atan2(dy, dx);
			shoot(x,y,dir);
			fireRate = MonsterProjectile.FIRE_RATE;
		}
	}
	public void render(Screen screen){
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.player_up;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
					
			} 
			
		}
		if (dir == 1){
			sprite = Sprite.player_side;
			if (walking) {
			if (animate % 20 > 10) {
				sprite = Sprite.player_side_1;
			} else {
				sprite = Sprite.player_side_2;
			}
			}
				
		 	
		}
		if (dir == 2) {
			sprite = Sprite.player_down;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
					
			} 			
		}
		if (dir == 3) {
			flip = 1;
			sprite = Sprite.player_side;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
					
			} 	
		}
			
		
		screen.renderPlayer(x-16, y- 16, sprite, flip);
	}

}
