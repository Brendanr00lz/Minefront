package me.brendan.minefront.src.entity.entities;

import me.brendan.minefront.src.Minefront;
import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.input.InputHandler;

public class Player extends Mob {

	private InputHandler input;

	public Player(int id, InputHandler input) {
		super(id);
		this.input = input;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;

		if (input.isMovingWithKey) {
			if (input.up) ya--;
			if (input.down) ya++;
			if (input.left) xa--;
			if (input.right) xa++;
		} else {
			xa = input.mouseX;
			ya = input.mouseY;
		}
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
		}
	}

	public void render(Screen screen) {
		screen.render(Minefront.SHEET, x, y, 2, 0, true);
	}
}