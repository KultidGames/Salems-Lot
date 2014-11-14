 package Game;

 import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Time extends TimerTask{

	public void run() {
		//Create a panel to use as the glass pane  
		JPanel night = new JPanel()  
		{ 
			public void Test(){
			Timer timer = new Timer();
			 timer.schedule(new Time(), 0, 300000);
			}
		   public void paintComponent(Graphics g)  
		   {   
			   float dark = (float) 0.0;
			   
		      g.setColor(new Color(1, 0, 0, dark));  
		     // g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);  
		   }  
		};  
		/* every 10 seconds, add dark += 0.10
		 * if timer = dark = 100, delay for 5 minutes
		 * if timer 
		 */
	}
	
} 
