package me.brendan.minefront.src.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import me.brendan.minefront.src.Minefront;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right;
	public int mouseX, mouseY, mouseDragX, mouseDragY, button;
	public boolean isMovingWithKey;

	public InputHandler(Minefront game) {
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
	}

	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	public void releaseAll() {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = true;
			isMovingWithKey = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = false;
			isMovingWithKey = true;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		button = e.getButton();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		mouseDragX = e.getX();
		mouseDragY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		isMovingWithKey = false;
	}
}