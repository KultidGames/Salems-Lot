package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_W){
			Game.getPlayer().up = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_A){
			Game.getPlayer().lt = true;			
		}
		if(e.getKeyCode()== KeyEvent.VK_S){
			Game.getPlayer().dn = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_D){
			Game.getPlayer().rt = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_W){
			Game.getPlayer().up = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_A){
			Game.getPlayer().lt = false;			
		}
		if(e.getKeyCode()== KeyEvent.VK_S){
			Game.getPlayer().dn = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_D){
			Game.getPlayer().rt = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
