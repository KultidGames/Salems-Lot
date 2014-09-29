package Game.tiles;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.ImageManager;

public class InsideAirDuct2Tile extends Tile {

	public InsideAirDuct2Tile(ImageManager im) {
		super(im);
	}

	public void tick() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.IairTile2, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE,null);
	}
	public boolean isSolid(){
		return true;
	}
}
