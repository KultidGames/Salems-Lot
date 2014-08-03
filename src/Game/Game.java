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

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 200, HEIGHT = 200, SCALE = 2, TILESIZE = 16;
	public static boolean running = false;
	public Thread gameThread;
	
	private BufferedImage spriteSheet;
	private static ImageManager im;
	
	private static Player player;
	private Level l1;
	
	public void init(){
		ImageLoader loader = new ImageLoader();
		spriteSheet = loader.load("/spritesheet.png");
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		
		im = new ImageManager(ss);
		
		player = new Player(0, 0, im);
		BufferedImage limage = loader.load("/level.png");
		l1 = new Level(limage);
		this.addKeyListener(new KeyManager());
	}
	
	public synchronized void start(){
		if(running)return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	public synchronized void stop(){
		if(!running)return;
		running=false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
		}
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
		player.tick();
	}
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//RENDER HERE
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		l1.render(g);
		player.render(g);
		//RENDER END
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame("Tile RPG"); //Title Here
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		
		game.start();
	}
	public static Player getPlayer(){
		return player;
	}
	public static ImageManager getImageManager(){
		return im;
	}
}
