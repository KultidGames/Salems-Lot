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
				case "844203"://Tree - 5
					tiles[x][y] = 5;
					break;
				case "fffc9f"://Sand - 6
					tiles[x][y] = 6;
					break;
				case "000000"://Wall - 7
					tiles[x][y] = 7;
					break;
				case "d3d3d3"://Road - 8
					tiles[x][y] = 8;
					break;
				case "48bc00"://Emerald Brick - 9
					tiles[x][y] = 9;
					break;
				case "4c4c4e"://Tv - 10
					tiles[x][y] = 10;
					break;
				case "ff0000"://Clay Brick - 11
					tiles[x][y] = 11;
					break;
				case "ffffff"://White Brick - 12
					tiles[x][y] = 12;
					break;
				case "592300"://Dark Plank - 13
					tiles[x][y] = 13;
					break;
				case "a0a0a0"://Light Brick - 14
					tiles[x][y] = 14;
					break;
				case "633203"://Wood - 15
					tiles[x][y] = 15;
					break;
				case "ff7575"://Floor - 16
					tiles[x][y] = 16;
					break;
				case "e5e5e5"://Air Duct - 17
					tiles[x][y] = 17;
					break;
				case "c0c0c0"://Inside Air Duct - 18
					tiles[x][y] = 18;
					break;
				case "808080"://Inside Air Duct =Solid= - 19
					tiles[x][y] = 19;
					break;
				case "212122"://Radio - 20
					tiles[x][y] = 20;
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
		
		int x0 = Math.max(xo / (Game.TILESIZE * Game.SCALE), 0);
		int y0 = Math.max(yo / (Game.TILESIZE * Game.SCALE), 0);
		int x1 = Math.min((xo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, w);
		int y1 = Math.min((yo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, h);
		
		for(int y = y0; y < y1;y++){
			for(int x = x0; x < x1;x++){
				getTile(x, y).render(g, x * Game.TILESIZE * Game.SCALE - xo,y * Game.TILESIZE * Game.SCALE - yo);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= w || y >= h) // || means 'or'
			return Tile.wall;
		
		
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
		case 6:
			return Tile.sand;
		case 7:
			return Tile.wall;
		case 8:
			return Tile.road;
		case 9:
			return Tile.ebrick;
		case 10:
			return Tile.tv;
		case 11:
			return Tile.cbrick;
		case 12:
			return Tile.wbrick;
		case 13:
			return Tile.dplank;
		case 14:
			return Tile.lbrick;
		case 15:
			return Tile.wood;
		case 16:
			return Tile.floor;
		case 17:
			return Tile.AirDuct;
		case 18:
			return Tile.IairDuct;
		case 19:
			return Tile.IairDuct2;
		case 20:
			return Tile.Radio;
		default:
			return Tile.brick;
		}
	}
}
