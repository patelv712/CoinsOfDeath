package Game;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener //Canvas is a blank work space to work and then override with Jfame
{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 3;
	
	BufferedImage myImage = null; //BufferedImage is a class used to handle data regarding an image
	
	//Player p;
	Background p; 
	public Game()
	{
		super ("Coins of Death");
		//this.p = new Player();
		addKeyListener(this);
		p = new Background();
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
			//this.add(pe);
			this.add(p);
			//this.add(p);
			while (true)
			{
				Thread.sleep(16);
				this.repaint();
				//p.repaint();
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();  //helps determine where the error is if there is one
		}
	}	
	public void keyTyped(KeyEvent evt)
	{
		
		//do nothing rlly
	}
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		int key = e.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_W:
			{
				p.moveUp();
				System.out.println("hhhh" + e.getKeyChar());  //for testing purposes
				break;
			}
			case KeyEvent.VK_A:
			{
				p.moveLeft();
				break;
			}
			case KeyEvent.VK_S:
			{
				p.moveDown();
				break;
			}
			case KeyEvent.VK_D:
			{
				p.moveRight();
				break;
			}
			/*default:
			{
				System.out.println("bruhhhh");
				break;
			}*/
		}
		
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}
	public static void main (String [] args)
	{
		Game x = new Game();
		x.start();
	}
	
}
