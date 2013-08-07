package me.brendan.minefront.src.entity;

import me.brendan.minefront.src.entity.utils.BoundingBox;
import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.level.Level;

public class Entity {

	public int x, y;
	public boolean isRemoved = false;
	protected Level level;
	protected BoundingBox bb;
	public int id;

	public Entity(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public void tick() {
	}

	public void render(Screen screen) {
	}

	public void remove() {
		isRemoved = true;
	}

	public boolean isRemoved() {
		return this.isRemoved;
	}
}