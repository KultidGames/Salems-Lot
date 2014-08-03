package Game.tiles;

import java.awt.Graphics;
import Game.Game;

import Game.gfx.ImageManager;

public class GrassTile extends Tile {

	public GrassTile(ImageManager im) {
		super(im);
	}

	public void tick() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.grassTile, x, y, 16 * Game.TILESIZE, 16 * Game.TILESIZE,null);
	}

}
