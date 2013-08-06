package me.brendan.minefront.src.level.tile;

import me.brendan.minefront.src.Minefront;
import me.brendan.minefront.src.graphics.Screen;

public class ObiTile extends Tile {

	public ObiTile(int id) {
		super(id);
	}

	public void render(Screen screen, int x, int y) {
		screen.render(Minefront.SHEET, x << 4, y << 4, 1, 0, true);
	}
}
