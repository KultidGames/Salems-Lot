package Game.gfx;

import java.awt.image.BufferedImage;

public class ImageManager {

	public BufferedImage grassTile, plankTile, brickTile, treeTile, sandTile, wallTile, roadTile, doorTile, ebrickTile, TvTile, cbrickTile, wbrickTile, dplankTile, lbrickTile, woodTile, floorTile, AirDuctTile, IairTile, IairTile2, RadioTile;
	public BufferedImage[] playerUp, playerDown, playerLeft, playerRight, idle, playerRmid, playerLmid;//[] = array
	public BufferedImage[] waterTile;
	public BufferedImage[] coin;
	public BufferedImage[] swimUp, swimDown, swimLeft, swimRight;
	
	public ImageManager(SpriteSheet ss){
		ImageLoader loader = new ImageLoader();
		playerUp = new BufferedImage[2];
			playerUp[0] = ss.crop(0,1,16,16);
			playerUp[1] = ss.crop(0,6,16,16);
		playerDown = new BufferedImage[2];
			playerDown[0] = ss.crop(0,0,16,16);
			playerDown[1] = ss.crop(0,7,16,16);
		playerLeft = new BufferedImage[3];
			playerLeft[0] = ss.crop(0,5,16,16);
			playerLeft[1] = ss.crop(0,11,16,16);
			playerLeft[2] = ss.crop(0,4,16,16);
		playerRight = new BufferedImage[3];
			playerRight[0] = ss.crop(0,3,16,16);
			playerRight[1] = ss.crop(0,10,16,16);
			playerRight[2] = ss.crop(0,2,16,16);
		idle = new BufferedImage[2];
			idle[0] = ss.crop(0,8,16,16);
			idle[1] = ss.crop(0,9,16,16);
		swimDown = new BufferedImage[4];
			swimDown[0] = ss.crop(2, 10, 16, 16);
			swimDown[1] = ss.crop(3, 10, 16, 16);
			swimDown[2] = ss.crop(4, 10, 16, 16);
			swimDown[3] = ss.crop(5, 10, 16, 16);
		swimRight = new BufferedImage[4];
			swimRight[0] = ss.crop(2, 9, 16, 16);
			swimRight[1] = ss.crop(3, 9, 16, 16);
			swimRight[2] = ss.crop(4, 9, 16, 16);
			swimRight[3] = ss.crop(5, 9, 16, 16);
		
		waterTile = new BufferedImage[2];
			waterTile[0] = ss.crop(2,0,16,16);
			waterTile[1] = ss.crop(2, 6, 16, 16);
		coin = new BufferedImage[2];
			coin[0] = loader.load("/Menu/Coin.png");
			coin[1] = loader.load("/Menu/Coin1.png");
		
		grassTile = ss.crop(1, 0, 16, 16);
		//waterTile = ss.crop(2, 0, 16, 16);
		plankTile = ss.crop(3, 0, 16, 16);
		brickTile = ss.crop(4, 0, 16, 16);
		//treeTile = ss.crop(2, 3, 16, 32);
		sandTile = ss.crop(6, 0, 16, 16);
		wallTile = ss.crop(7, 0, 16, 16);
		roadTile = ss.crop(5, 2, 16, 16);
		ebrickTile = ss.crop(5, 0, 16, 16);
		TvTile = ss.crop(4, 3, 16, 16);
		cbrickTile = ss.crop(5, 1, 16, 16);
		wbrickTile = ss.crop(6, 4, 16, 16);
		dplankTile = ss.crop(5, 4, 16, 16);
		lbrickTile = ss.crop(4, 5, 16, 16);
		woodTile = ss.crop(7, 1, 16, 16);
		floorTile = ss.crop(6, 3, 16, 16);
		AirDuctTile = ss.crop(7, 5, 16, 16);
		IairTile = ss.crop(7, 6, 16, 16);
		IairTile2 = ss.crop(7, 4, 16, 16);
		RadioTile = ss.crop(5, 5, 16, 16);
	}
	
}
