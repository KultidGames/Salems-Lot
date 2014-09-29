package Game.entities;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.Animation;
import Game.gfx.ImageManager;
import Game.tiles.EBrickTile;
import Game.tiles.TvTile;
import Game.tiles.WaterTile;

public class Player{

	private int x, y, xo, yo, xs,ys;
	private ImageManager im;
	public boolean up = false, dn = false, lt = false, rt = false;
	private int SPEED = 8, SIZE = 16; //Collision Size
	public static int health=10;
	public static boolean isSwimming = false;
	
	private Animation upAnimation, downAnimation, leftAnimation, rightAnimation, idle, swimDown, swimUp, swimLeft,swimRight;
	
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		xo=0;
		yo=0;
		xs=0;
		ys=0;
		this.im = im;
		
		upAnimation = new Animation(im.playerUp, 300);
		downAnimation = new Animation(im.playerDown, 300);
		leftAnimation = new Animation(im.playerLeft, 200);
		rightAnimation = new Animation(im.playerRight, 200);
		idle = new Animation(im.idle, 2000);
		swimDown = new Animation(im.swimDown, 500);
		swimUp = new Animation(im.swimUp, 500);
		swimLeft = new Animation(im.swimLeft, 500);
		swimRight = new Animation(im.swimRight, 500);

	}
	public void tick(){
		xs=0;
		ys=0;
		if (up){
			ys-= SPEED;
		}else if (dn){
			ys += SPEED;
		}else if (lt){
			xs -= SPEED;
		}else if (rt){
			xs += SPEED;
		}
		move(xs, ys);
		
		if (isSwimming){
			swimDown.tick();
			swimUp.tick();
			swimLeft.tick();
			swimRight.tick();
		}if (!isSwimming){
			upAnimation.tick();
			downAnimation.tick();
			leftAnimation.tick();
			rightAnimation.tick();
			idle.tick();
		}
	}
	public void move(int xs, int ys){
		if (!collision(xs, 0)){
		xo += xs;
		}
		if (!collision(0, ys)){
			yo += ys;
			}
	}
	private boolean collision(int xs, int ys){
			
		if(Game.getLevel().getTile((xo + xs + x + SIZE * Game.SCALE) / (16 * Game.SCALE), (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE))instanceof WaterTile){
			isSwimming = true;	
		}
		else {
			isSwimming = false;
		if(Game.getLevel().getTile((xo + xs + x) / (16 * Game.SCALE) + 1, (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x + SIZE * Game.SCALE + 1) / (16 * Game.SCALE), (yo + ys + y) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x) / (16 * Game.SCALE), (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x + SIZE * Game.SCALE) / (16 * Game.SCALE), (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE)).isSolid())
			return true;
		//LOOK HERE LATER
		return false;
	}
		return false;
	}
	public void render(Graphics g){
		if (isSwimming){
	        if (up) {
	            swimUp.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        } 
	        if (dn){
	            swimDown.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        }
	        if (rt){
	            swimRight.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        }
	        if (lt){
	            swimLeft.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        }
	    }       
		else if (!isSwimming){
	        if(up){
	            upAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        } 
	        if (dn){
	            downAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        }
	        if (rt){
	            rightAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	        }
	        if (lt){
	            leftAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
	    } else
	            idle.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);

	}
	}
	public int getXo(){
		return xo;
	}
	public int getYo(){
		return yo;
	}
	
}
