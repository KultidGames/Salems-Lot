package Game.tiles;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.Animation;
import Game.gfx.ImageManager;

public class WaterTile extends Tile {
	private Animation waterTile;

	public WaterTile(ImageManager im) {
		super(im);
		waterTile = new Animation(im.waterTile, 300);
	}
	public void tick() {
		waterTile.tick();
	}

	public void render(Graphics g, int x, int y) {
		//g.drawImage(im.waterTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE,null);
		waterTile.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	}
}
