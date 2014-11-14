package Game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Game.entities.Player;
import Game.gfx.ImageLoader;
import Game.gfx.ImageManager;
import Game.gfx.SpriteSheet;
import Game.levels.Level;
import Game.gfx.Sound;
public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 180, HEIGHT = 150, SCALE = 6, TILESIZE = 16;
	public static boolean running = false;
	public Thread gameThread;
	
	private BufferedImage spriteSheet, bkgrnd;
	public static BufferedImage logo, play, help, quit, pauseimg, menuimg, settings, back;
	private static ImageManager im;
	private BufferedImage H10, H9, H8, H7, H6, H5, H4, H3, H2, H1, Death, Hearts;
	
	private Menu menu;
	private Menu pause;
	private Menu helpDis;
	
	private static Player player;
	public static Level level;
	public final String version = "Conceptiualization - 1.0";
	
	
	
	public static enum STATE{
		MENU,
		GAME,
		PAUSE,
	};
	
	public static STATE State = STATE.MENU;
	
	public void init(){ //INITIALIZER
		ImageLoader loader = new ImageLoader();
		spriteSheet = loader.load("/spritesheet.png");
		bkgrnd = loader.load("/Menu/TitleScreen.png");
		logo = loader.load("/Menu/Logo.png");
		play = loader.load("/Menu/Play.png");
		help = loader.load("/Menu/Help.png");
		quit = loader.load("/Menu/Quit.png");
		
		pauseimg = loader.load("/Menu/Pause.png");
		menuimg = loader.load("/Menu/Menu.png");
		settings = loader.load("/Menu/Settings.png");
		back = loader.load("/Menu/Return.png");
		
		H10 = loader.load("/Hearts/H10.png");
		H9 = loader.load("/Hearts/H9.png");
		H8 = loader.load("/Hearts/H8.png");
		H7 = loader.load("/Hearts/H7.png");
		H6 = loader.load("/Hearts/H6.png");
		H5 = loader.load("/Hearts/H5.png");
		H4 = loader.load("/Hearts/H4.png");
		H3 = loader.load("/Hearts/H3.png");
		H2 = loader.load("/Hearts/H2.png");
		H1 = loader.load("/Hearts/H1.png");
		Death = loader.load("/Hearts/Death.png"); 
		
	//	Hearts = loader.load("/Hearts/H" + Player.health + ".png");
		
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		
		im = new ImageManager(ss);
		
		player = new Player(WIDTH * SCALE / 2 - 55, HEIGHT * SCALE / 2 - 85, im); //Can Change Area
		this.addKeyListener(new KeyManager());
		this.addMouseListener(new MouseInput());
		
		level = new Level (loader.load("/level.png"));
		
		menu = new Menu();
	}
	public synchronized void start(){
		if(running)return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		Sound.ForYou.play();
	}
	public synchronized void stop(){
		if(!running)return;
		running=false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
		}
	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1){
				tick();
				delta--;
			}
			render();
		}
		stop();
	}
	public void tick(){
		if(State == STATE.GAME){
			player.tick();
		}else if (State == STATE.MENU || State == STATE.PAUSE){
		}
	}
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//RENDER HERE
		if(State == STATE.GAME){		
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		level.render(g);
		player.render(g);
			if (Player.health == 10)
				g.drawImage(H10, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 9) 
				g.drawImage(H9, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 8) 
				g.drawImage(H8, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 7) 
				g.drawImage(H7, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 6) 
				g.drawImage(H6, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 5) 
				g.drawImage(H5, -1, 795,150 * 5, 11 * 5, null);
		     if (Player.health == 4) 
				g.drawImage(H4, -1, 795,150 * 5, 11 * 5, null);
			 if (Player.health == 3) 
				g.drawImage(H3, -1, 795,150 * 5, 11 * 5, null);
			 if (Player.health == 2) 
				g.drawImage(H2, -1, 795,150 * 5, 11 * 5, null);
			 if (Player.health == 1) 
				g.drawImage(H1, -1, 795,150 * 5, 11 * 5, null);
			 if (Player.health == 0) 
				g.drawImage(H1, -1, 795,150 * 5, 11 * 5, null);
			
		}else if (State == STATE.MENU){
			g.drawImage(bkgrnd, 0, 0, WIDTH * SCALE , HEIGHT * SCALE, this);
			g.drawImage(logo, 325, 85, 125 * SCALE , 75 * SCALE, null);
			g.drawImage(play, 220, 340, 50 * SCALE , 25 * SCALE, null);
			g.drawImage(help, 220, 500, 50 * SCALE , 25 * SCALE, null);
			g.drawImage(quit, 220, 660, 50 * SCALE , 25 * SCALE, null);
			
		} else if (State == STATE.PAUSE){
			g.drawImage(pauseimg, 0, 0, WIDTH * SCALE , HEIGHT * SCALE, this);
			g.drawImage(play, 200, 125, 50 * SCALE , 25 * SCALE, null);
			g.drawImage(menuimg, 200, 300, 50 * SCALE , 25 * SCALE, null);
			g.drawImage(settings, 800, 700, 25 * SCALE , 16 * SCALE, null);
		}
		
		//RENDER END
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame("Salem's Lot"); //Title Here
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		
		game.start();
	}
	public static Level getLevel(){
		return level;
	}
	public static Player getPlayer(){
		return player;
	}
	public static ImageManager getImageManager(){
		return im;
	}
}
//On Collision Detection
//https://www.youtube.com/watch?v=MDKbwnGNX_s
