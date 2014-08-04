package Game.tiles;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.ImageManager;

public class WallTile extends Tile {

	public WallTile(ImageManager im) {
		super(im);
	}

	public void tick() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.wallTile, x, y, 16 * Game.TILESIZE, 16 * Game.TILESIZE,null);
	}
	public boolean isSolid(){
		return true;
	}
}
