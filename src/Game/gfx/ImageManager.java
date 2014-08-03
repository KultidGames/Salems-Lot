package Game.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {

	public BufferedImage player, grassTile, waterTile, plankTile, brickTile, treeTile;
	
	public ImageManager(SpriteSheet ss){
		player = ss.crop(0, 0, 16, 16);
		grassTile = ss.crop(1, 0, 16, 16);
		waterTile = ss.crop(2, 0, 16, 16);
		plankTile = ss.crop(3, 0, 16, 16);
		brickTile = ss.crop(3, 0, 16, 16);
		treeTile = ss.crop(4, 0, 16, 16);
	}
	
}
