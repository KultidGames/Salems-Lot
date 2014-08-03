package Game.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Game.Game;

import Game.tiles.Tile;

public class Level {
	
	private int[][] tiles;
	private int w, h;

	public Level(BufferedImage levelImage){
		loadLevel(levelImage);
		w = levelImage.getWidth();
		h = levelImage.getHeight();
	}
	
	public void loadLevel(BufferedImage levelImage){
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
		for (int y=0; y < levelImage.getHeight();y++){
			for (int x=0; x < levelImage.getWidth();x++){
				Color c = new Color(levelImage.getRGB(x, y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
				
				switch(h){ //LETTERS MUST BE LOWERCASE
				case "00ff21"://Grass - 1
					tiles[x][y] = 1;
					break;
				case "ffeb8c"://Plank - 2
					tiles[x][y] = 2;
					break;
				case "c4c4c4"://Brick - 3
					tiles[x][y] = 3;
					break;
				case "0026ff"://Water - 4
					tiles[x][y] = 4;
					break;
				case "844204"://Tree - 5
					tiles[x][y] = 5;
					break;
				default:
					tiles[x][y] = 3;
					break;
				
				}
			}
		}
	}
	
	public void render(Graphics g){
		int xo = Game.getPlayer().getXo();
		int yo = Game.getPlayer().getYo();
		
		for(int y = 0; y < h;y++){
			for(int x = 0; x < w;x++){
				getTile(x, y).render(g, x * Game.TILESIZE * Game.SCALE - xo,y * Game.TILESIZE * Game.SCALE - yo);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		switch(tiles[x][y]){
		case 1:
			return Tile.grass;
		case 2:
			return Tile.plank;
		case 3:
			return Tile.brick;
		case 4:
			return Tile.water;
		case 5:
			return Tile.tree;
		default:
			return Tile.brick;
		}
	}
	
}
