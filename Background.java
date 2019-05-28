package Game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Background extends JComponent
{

	BufferedImage myImage = null;
	BufferedImage guy = null;
	ImageObserver y = null;
	Graphics2D x = null;

	Component a = new Button();
	KeyEvent W = new KeyEvent(a,1,1,0, KeyEvent.VK_W, 'w' );
	KeyEvent A = new KeyEvent(a,1,1,0, KeyEvent.VK_A, 'a' );
	KeyEvent S = new KeyEvent(a,1,1,0, KeyEvent.VK_S, 's' );
	KeyEvent D = new KeyEvent(a,1,1,0, KeyEvent.VK_D, 'd' );
	
	int xC = 700;
	int yC = 350;
	int h = 150;
	int w = 150;
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try
		{
			myImage = ImageIO.read(new URL("https://www.pennington.com/-/media/images/pennington-na/us/blog/seed/all-you-need-to-know-about-bermudagrass/bermuda-header.jpg")); //used to handle image data
			super.paintComponent(g);
			g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight()/2 + 300, this); //use this not null bc when method called first time image has not been loaded yet so error if null
			x = (Graphics2D) g;
			x.setColor(Color.GREEN); //just in case background is still there
			//x.fillOval(700, 400, 100, 100);
			guy = ImageIO.read(new URL("https://images-na.ssl-images-amazon.com/images/I/61O3LuvpDML._SY355_.png"));
			x.drawImage(guy,xC,yC, h, w,  new Color(0,0,0,0), y);
			keyPress(A);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	public void keyPress(KeyEvent evt)
	{
		
		int key = evt.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_W:
			{
				yC--;
				System.out.println("" + evt.getKeyChar());  //for testing purposes
				break;
			}
			case KeyEvent.VK_A:
			{
				xC--;
				break;
			}
			case KeyEvent.VK_S:
			{
				yC++;
				break;
			}
			case KeyEvent.VK_D:
			{
				xC++;
				break;
			}
			default:
			{
				System.out.println("bruhhhh");
				break;
			}
		}
		x.drawImage(guy,xC,yC, h, w,  new Color(0,0,0,0), y)	;
	}
	
}
