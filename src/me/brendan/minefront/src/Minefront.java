package me.brendan.minefront.src;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.graphics.SpriteSheet;
import me.brendan.minefront.src.level.Level;

public class Minefront extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static final String NAME = "Minefront";
	public static final int WIDTH = 160;
	public static final int HEIGHT = 120;
	private static final int SCALE = 5;

	private boolean running = false;
	private Thread thread;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage overlay;
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public static SpriteSheet SHEET;
	private Screen screen;
	private Level level;

	public void start() {
		if (running) return;

		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	public void stop() {
		if (!running) return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		double delta = 0;
		double nsPerTick = 1000000000.0 / 60.0;
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		int frames = 0;
		int ticks = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}

			if (shouldRender) {
				frames++;
				render();
			}

			while (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				System.out.println(frames + " fps, " + ticks + " ticks");
				frames = 0;
				ticks = 0;
			}
		}
	}

	private void init() {
		requestFocus();

		SHEET = new SpriteSheet("/icons.png");
		screen = new Screen(WIDTH, HEIGHT);
		level = new Level(64, 64);
		try {
			overlay = ImageIO.read(Minefront.class.getResource("/overlay.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tick() {
		level.tick();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		int xScroll = 0;
		int yScroll = 0;
		level.renderBackground(screen, xScroll, yScroll);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		int ww = WIDTH * SCALE;
		int hh = HEIGHT * SCALE;
		int xo = (getWidth() - ww) / 2;
		int yo = (getHeight() - hh) / 2;
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 203, 36, 583, 524, null);
		g.drawImage(overlay, xo, yo, ww, hh, null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Minefront game = new Minefront();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(Minefront.NAME);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(false);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		game.start();
	}
}