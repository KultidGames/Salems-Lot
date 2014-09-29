package Game.tiles;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.ImageManager;

public class TvTile extends Tile {

	public TvTile(ImageManager im) {
		super(im);
	}

	public void tick() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(im.TvTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE,null);
	}
	public boolean isSolid(){
		return true;
	}
}
