package Game.tiles;

import java.awt.Graphics;
import Game.Game;

import Game.gfx.ImageManager;

public abstract class Tile {

	protected ImageManager im;
	
	public static Tile grass = new GrassTile(Game.getImageManager());
	public static Tile water = new WaterTile(Game.getImageManager());
	public static Tile plank = new PlankTile(Game.getImageManager());
	public static Tile brick = new BrickTile(Game.getImageManager());
	public static Tile tree = new TreeTile(Game.getImageManager());
	
	public Tile(ImageManager im){
		this.im=im;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g, int x, int y);
}
