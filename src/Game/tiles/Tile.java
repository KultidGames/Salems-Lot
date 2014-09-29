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
	public static Tile sand = new SandTile(Game.getImageManager());
	public static Tile wall = new WallTile(Game.getImageManager());
	public static Tile road = new RoadTile(Game.getImageManager());
	public static Tile ebrick = new EBrickTile(Game.getImageManager());
	public static Tile tv = new TvTile(Game.getImageManager());
	public static Tile cbrick = new ClayBrick(Game.getImageManager());
	public static Tile wbrick = new WhiteBrickTile(Game.getImageManager());
	public static Tile dplank = new DarkPlankTile(Game.getImageManager());
	public static Tile lbrick = new LightBrickTile(Game.getImageManager());
	public static Tile wood = new WoodTile(Game.getImageManager());
	public static Tile floor = new TiledFloorTile(Game.getImageManager());
	public static Tile AirDuct = new AirDuctTile(Game.getImageManager());
	public static Tile IairDuct = new InsideAirDuctTile(Game.getImageManager());
	public static Tile IairDuct2 = new InsideAirDuct2Tile(Game.getImageManager());
	public static Tile Radio = new RadioTile(Game.getImageManager());
	
	public Tile(ImageManager im){
		this.im=im;
	}
	public abstract void tick();
	public abstract void render(Graphics g, int x, int y);

	public boolean isSolid(){
		return false;
	}
}
//https://www.youtube.com/watch?v=lz03EbZHPGA 9:57