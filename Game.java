package Game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame //Canvas is a blank work space to work and then override with Jfame
{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 3;
	
	BufferedImage myImage = null; //BufferedImage is a class used to handle data regarding an image
	
	public Game()
	{
		super ("Dungeons of Death");
	}
	public void start()
	{
		try
		{
			this.setLocation(200, 200); 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
			this.setVisible(true); //sets the visibility of the component. It is by default false.
			this.setFocusable(true);  
			this.setResizable(false); //makes it so that the window size can not be adjusted
			this.pack(); //sizes the frame so that all its contents are at or above their preferred sizes.
			Background p = new Background();
			this.add(p);
			while (true)
			{
				Thread.sleep(16);
				this.repaint();
				this.pack();
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();  //helps determine where the error is if there is one
		}
	}	
	
	public static void main (String [] args)
	{
		Game x = new Game();
		x.start();
	}
	
}
