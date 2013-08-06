package me.brendan.minefront.src.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	
	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right;
	public int mouseX, mouseY, mouseDragX, mouseDragY, button;
	
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

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}