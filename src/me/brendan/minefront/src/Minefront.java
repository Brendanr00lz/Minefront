package me.brendan.minefront.src;

import java.awt.Canvas;

public class Minefront extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private static final String NAME = "Minefront";
	public static final int WIDTH = 160;
	public static final int HEIGHT = 120;
	private static final int SCALE = 5;
	
	private boolean running = false;
	private Thread thread;
	
	public void start() {
		if (running) return;
		
		running = true;
	}
	
	public void stop() {
		
	}
	
	public void run() {
		
	}
}