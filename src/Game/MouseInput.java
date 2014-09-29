package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Game.Game.STATE;
import Game.entities.Player;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) 
	{
		if (Game.State == STATE.MENU){
		int mx = e.getX();
		int my = e.getY();
		/* g.drawImage(play, 220, 340, 50 * SCALE , 25 * SCALE, null);
		g.drawImage(help, 220, 500, 50 * SCALE , 25 * SCALE, null);
		g.drawImage(quit, 220, 660, 50 * SCALE , 25 * SCALE, null); 
		// X coords, Y coords, Width in px, height in px*/
		
		// Play
		if(mx >= 220 && mx <= 520){
			if(my >= 340 && my <= 490){
				Game.State = Game.STATE.GAME;
			}
		}
		// Help
		if(mx >= 223 && mx <= 520){
			if(my >= 500 && my <= 650){
				
			}
		}
		// Quit
		if(mx >= 220 && mx <= 520){
			if(my >= 660 && my <= 810){
				System.exit(1);
			}
		}
		}else if (Game.State == STATE.PAUSE && Player.health != 0){
			int mx = e.getX();
			int my = e.getY();
			//Resume
			if(mx >= 200 && mx <= 500 ){
				if(my >= 125 && my <= 275){
					Game.State = Game.STATE.GAME;
				}
			}
		//Main Menu
			if(mx >= 200 && mx <= 500 ){
				if(my >= 300 && my <= 450){
					Game.State = Game.STATE.MENU;
				}
			}
		// Settings
			if(mx >= 800 && mx <= 950 ){
				if(my >= 700 && my <= 796){
					Player.health--;
				}
			} 
		
			else if (Player.health == 0){
				if(mx >= 100 && mx <= 250 ){
					if(my >= 760 && my <= 796){
						Game.State = Game.STATE.MENU;
					}
				}
		}
		}
		}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
