package me.brendan.minefront.src.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public int width, height;
	public int[] pixels;
	
	public SpriteSheet(String path) {
		load(path);
	}
	
	public void load(String path) {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			this.width = image.getWidth();
			this.height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}