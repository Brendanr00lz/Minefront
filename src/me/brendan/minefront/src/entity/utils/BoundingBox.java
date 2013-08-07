package me.brendan.minefront.src.entity.utils;

import me.brendan.minefront.src.entity.Entity;

public class BoundingBox {

	private int x, y, width, height;
	private Entity e;

	public BoundingBox(Entity e, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.e = e;
		this.width = width;
		this.height = height;
	}

	public Entity getEntity() {
		return e;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getNumOfPoints() {
		return 4;
	}
}