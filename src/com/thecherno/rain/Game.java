package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.level.Level;
import com.thecherno.rain.level.RandomLevel;
import com.thecherno.rain.level.SpawnLevel;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Screen screen;
	private BufferedImage view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)view.getRaster().getDataBuffer()).getData(); 
	
	private boolean running = false;
	private JFrame frame;
	private Level level;
	private Player player;
	private Thread gameThread;
	private Keyboard keyboard;
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		keyboard = new Keyboard();
		level = new SpawnLevel("/textures/level.png");
		player = new Player((16 * 16) / 2,(16 * 16) /2 ,keyboard);
		addKeyListener(keyboard);
	}
	
	private synchronized void start(){
		running = true;
		gameThread  = new Thread(this, "Display");
		gameThread.start();
	}
	
	private synchronized void stop(){
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; 
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta+= (now-lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer+= 1000;
				frame.setTitle("Rain | " + updates + " ups, " + frames + "fps");
				System.out.println(updates + " ups, " + frames + "fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void update() {
		keyboard.update();
		player.update();
		
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - width / 2;
		int yScroll = player.y - height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(view, 0, 0,getWidth(),getHeight(),null);
		g.setFont(new Font("Courier",0,50));
		g.setColor(Color.WHITE);
		g.drawString("x:" + player.x +"y:" + player.y, 50, 50);
		g.dispose();
		bs.show();
	}

	

	public static void main(String[] args) {
		Game g = new Game();
		g.frame.setResizable(false);
		g.frame.setTitle("Rain");
		g.frame.add(g);
		g.frame.pack();
		g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.frame.setLocationRelativeTo(null);
		g.frame.setVisible(true);
		g.start();
	}
}
