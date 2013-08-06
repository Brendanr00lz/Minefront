package me.brendan.minefront.src.level.tile;

import me.brendan.minefront.src.graphics.Screen;
import me.brendan.minefront.src.level.Level;

public class Tile {

	public static Tile[] tiles = new Tile[256];

	public byte id;
	
	public static Tile GRASS = new GrassTile(0);
	public static Tile OBSIDIAN = new ObiTile(1);

	public Tile(int id) {
		this.id = (byte) id;
		if (tiles[id] != null) throw new RuntimeException("Error - Duplicate Tile ids!");
		tiles[id] = this;
	}
	
	public void tick(Level level, int x, int y) {
	}
	
	public void render(Screen screen, int x, int y) {
	}
}