package me.brendan.minefront.src.entity.entities;

import me.brendan.minefront.src.entity.Entity;

public class Mob extends Entity {

	protected int health, direction;

	public Mob(int id) {
		super(id);
	}

	public void tick() {

		if (health < 0) {
			die();
		}
	}

	protected void die() {
		remove();
	}

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (ya < 0) direction = 0;
		if (ya > 0) direction = 1;
		if (xa < 0) direction = 2;
		if (xa > 0) direction = 3;
		
		if (!checkCollision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public boolean checkCollision(int xa, int ya) {
		boolean colliding = false;
		return colliding;
	}
}