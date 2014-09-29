package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener{
	private int pause1 = 1;

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_W || e.getKeyCode()== KeyEvent.VK_UP ){
			Game.getPlayer().up = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_A || e.getKeyCode()== KeyEvent.VK_LEFT){
			Game.getPlayer().lt = true;			
		}
		if(e.getKeyCode()== KeyEvent.VK_S || e.getKeyCode()== KeyEvent.VK_DOWN){
			Game.getPlayer().dn = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_D || e.getKeyCode()== KeyEvent.VK_RIGHT){
			Game.getPlayer().rt = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_ENTER || e.getKeyCode()== KeyEvent.VK_SPACE){
			
		}
		if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
			//Game.State = Game.STATE.PAUSE;
			pause1 ++;
			
		if(pause1 == 2){
			Game.State = Game.STATE.PAUSE;
		}
		if(pause1 == 3){
			Game.State = Game.STATE.GAME;
			pause1 = 1;
		}
		}
		}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_W || e.getKeyCode()== KeyEvent.VK_UP){
			Game.getPlayer().up = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_A || e.getKeyCode()== KeyEvent.VK_LEFT){
			Game.getPlayer().lt = false;			
		}
		if(e.getKeyCode()== KeyEvent.VK_S || e.getKeyCode()== KeyEvent.VK_DOWN){
			Game.getPlayer().dn = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_D || e.getKeyCode()== KeyEvent.VK_RIGHT){
			Game.getPlayer().rt = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_ENTER || e.getKeyCode()== KeyEvent.VK_SPACE){
			
		}
	}
	


	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
