package me.brendan.minefront.src.graphics;

public class Screen {
	
	public final int width, height;
	public final int[] pixels;
	
	private int xOffset, yOffset;
	private byte BIT_MIRROR_X = 0x01;
	private byte BIT_MIRROR_Y = 0x02;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(int c) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = c;
		}
	}
	
	public void render(SpriteSheet sheet, int xPos, int yPos, int tile, int bits, boolean fixedPos) {
		if (fixedPos) {
			xPos -= xOffset;
			yPos -= yOffset;
		}
		
		boolean mirrorX = (bits & BIT_MIRROR_X) > 0;
		boolean mirrorY = (bits & BIT_MIRROR_Y) > 0;
		int xTile = tile % 32;
		int yTile = tile / 32;
		int tileOffset = (xTile << 3) + (yTile << 3) * sheet.width;
		
		for (int y = 0; y < 16; y++) {
			int yt = y + yPos;
			int ys = y;
			if (mirrorY) ys = 15 - y;
			if (yt < 0 || yt >= height) continue;
			for (int x = 0; x < 16; x++) {
				int xt = x + xPos;
				int xs = x;
				if (mirrorX) xs = 15 - x;
				if (xt < 0 || xt >= width) continue;
				
				int color = sheet.pixels[xs + ys * sheet.width + tileOffset];
				if (color != 0xFFFF00FF) {
					pixels[xt + yt * width] = color;
				}
			}
		}
	}
	
	public void setOffsets(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}