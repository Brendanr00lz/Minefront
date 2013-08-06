package me.brendan.minefront.src.level;

import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.level.tile.Tile;

public class Level {
	
	public int width, height;
	public byte[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new byte[width * height];
		
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = 0;
		}
	}
	
	public void tick() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile t = getTile(x, y);
				t.tick(this, x, y);
			}
		}
	}
	
	public void renderBackground(Screen screen, int xScroll, int yScroll) {
		int xOffset = xScroll >> 4;
		int yOffset = yScroll >> 4;
		int width = (screen.width + 15) >> 4;
		int height = (screen.height + 15) >> 4;
		
		screen.setOffsets(xOffset, yOffset);
		
		for (int yt = yOffset; yt <= height + yOffset; yt++) {
			for (int xt = xOffset; xt <= width + xOffset; xt++) {
				Tile t = getTile(xt, yt);
				t.render(screen, xt, yt);
			}
		}
		screen.setOffsets(0, 0);
	}
	
	public void renderSprites() {
		
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return Tile.OBSIDIAN;
		return Tile.tiles[tiles[x + y * width]];
	}
}