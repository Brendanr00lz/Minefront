package me.brendan.minefront.src.level.tile;

import me.brendan.minefront.src.Minefront;
import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(id);
	}

	public void render(Screen screen, int x, int y) {
		screen.render(Minefront.SHEET, x << 4, y << 4, 0, 0, true);
	}
}
