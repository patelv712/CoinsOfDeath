import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	
	private int xC = 700;
	private int yC = 350;
	public Background()
	{
		//addKeyListener(this);
		//setFocusable(true);
	}
	
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
			x.drawImage(guy,xC,yC, 150, 150,  new Color(0,0,0,0), y);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
	public void moveUp()
	{
		yC+= 10;
		repaint();
	}
	public void moveRight()
	{
		xC+= 10;
		repaint();
	}
	public void moveLeft()
	{
		xC -= 10;
		repaint();
	}
	public void moveDown()
	{
		yC -= 10;
		repaint();
	}
	
	
}
