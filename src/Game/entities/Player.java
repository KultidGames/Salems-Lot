package Game.entities;

import java.awt.Graphics;

import Game.Game;
import Game.gfx.ImageManager;

public class Player{

	private int x, y, xo, yo, xs,ys;
	private ImageManager im;
	public boolean up = false, dn = false, lt = false, rt = false;
	private final int SPEED = 3;
	
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		xo=0;
		yo=0;
		xs=0;
		ys=0;
		this.im = im;
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
		move(xs,ys);
	}
	
	public void move(int xs, int ys){
		xo += xs;
		yo += ys;
	}
	public int getXo(){
		return xo;
	}
	public int getYo(){
		return yo;
	}
	public void render(Graphics g){
		g.drawImage(im.player, x,y, 5 * Game.TILESIZE, 5 * Game.TILESIZE, null);
	}

}
