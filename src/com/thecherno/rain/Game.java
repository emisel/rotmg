package com.thecherno.rain;

public class Game implements Runnable {
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private boolean running = false;
	private Thread gameThread;
	
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
		while(running) {
			
		}
	}
}
