import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Background extends JComponent 
{
	
	private static final long serialVersionUID = 1L;
	
	BufferedImage myImage = null;
	BufferedImage guy = null; 
	ImageObserver y = null;
	Graphics2D x = null;
	ArrayList<Ellipse2D> coins = new ArrayList<Ellipse2D>();
	ArrayList<Integer> xCoins = new ArrayList<Integer>();
	ArrayList<Integer> yCoins = new ArrayList<Integer>();
	private int xC = 700;
	private int yC = 350;
	//Rectangle2D coin = null;
	Rectangle2D abc = new Rectangle2D.Double(xC, yC, 150, 150);

	public Background()
	{
		
		
		for(int i = 0; i < 10; i++)
		{
			int xThing = (int) (Math.random()*1200) + 1;
			int yThing = (int) (Math.random()*650) + 1;
			xCoins.add(xThing);
			yCoins.add(yThing);
		}
		
		for(int i=0;i<10;i++)
		{
			for(int j=i;j<10;j++)
			{
				if(xCoins.get(i)==xCoins.get(j)&&yCoins.get(i)==yCoins.get(j))
				{
					xCoins.set(i, (int) (Math.random()*1200) + 1);
					yCoins.set(i, (int) (Math.random()*650) + 1);
				}
				
				if(xCoins.get(i)==xC)
				{
					xCoins.set(i, (int) (Math.random()*1200) + 1);					
				}
			}
		}
		
		for(int j=0;j<10;j++)
		{
			coins.add(new Ellipse2D.Double(xCoins.get(j), yCoins.get(j), 50,50));

		}
			
	}

	
	public void moveUp()
	{
		yC --;
		repaint();
	}
	
	public void moveRight()
	{
		xC++;
		repaint();
	}
	
	public void moveLeft()
	{
		xC --;
		repaint();
	}
	
	public void moveDown()
	{
		yC ++;
		repaint();
	}
	
	public void intersects()
	{
		for(int i = 0; i < xCoins.size(); i++)
		{
			if (((Shape)abc).intersects(xCoins.get(i), yCoins.get(i), 50, 50)) 
			{				
				coins.remove(coins.get(i));
				abc = new Rectangle2D.Double(xC, yC, 150, 150);
				xCoins.remove(xCoins.get(i));
				yCoins.remove(yCoins.get(i));
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		try
		{
			
			myImage = ImageIO.read(new URL("https://www.pennington.com/-/media/images/pennington-na/us/blog/seed/all-you-need-to-know-about-bermudagrass/bermuda-header.jpg")); //used to handle image data
			super.paintComponent(g);
			g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight() + 300, this); //use this not null bc when method called first time image has not been loaded yet so error if null
			x = (Graphics2D) g;
			x.setColor(Color.YELLOW); //color of the coin
			//x.fillOval(700, 400, 100, 100);
			for (int i = 0; i < 10; i ++)
			{
				x.draw(coins.get(i));
				x.fill(coins.get(i));
			}
			x.setColor(Color.BLUE);
			x.fill(abc);
			x.draw(abc);
			abc = new Rectangle2D.Double(xC, yC, 150, 150);
			intersects();
			//guy = ImageIO.read(new URL("https://images-na.ssl-images-amazon.com/images/I/61O3LuvpDML._SY355_.png"));
			//x.drawImage(guy,xC,yC, 150, 150,  new Color(0,0,0,0), y);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }	
}
	

	
