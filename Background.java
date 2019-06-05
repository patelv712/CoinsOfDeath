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
	ArrayList<Integer> xCor = new ArrayList<Integer>();
	ArrayList<Integer> yCor = new ArrayList<Integer>();
	private int xC = 700;
	private int yC = 350;
	//Rectangle2D coin = null;
	private int xCoin = (int) (Math.random()*1350) +1;
	private int yCoin = (int) (Math.random()*700) +1;
	Rectangle2D abc = new Rectangle2D.Double(xC, yC, 150, 150);

	public Background()
	{
		for (int i = 0; i < 10; i ++)
		{
			xCor.add(xCoin);
			yCor.add(yCoin);
			coins.add(new Ellipse2D.Double( xCoin, yCoin, 50, 50 ) );
			xCoin = (int) (Math.random()*1350) +1;
			yCoin = (int) (Math.random()*700) +1;
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
		for(int i = 0; i < xCor.size(); i++)
		{
			if (((Shape)abc).intersects(xCor.get(i), yCor.get(i), 50, 50)) 
			{				
				coins.remove(coins.get(i));
				abc = new Rectangle2D.Double(xC, yC, 150, 150);
				xCor.remove(xCor.get(i));
				yCor.remove(yCor.get(i));
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
			//x.draw(abc);
			//abc = new Rectangle2D.Double(xC, yC, 150, 150);
			//intersects();
			guy = ImageIO.read(new URL("https://images-na.ssl-images-amazon.com/images/I/61O3LuvpDML._SY355_.png"));
			x.drawImage(guy,xC,yC, 150, 150,  new Color(0,0,0,0), y);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }	
}
	
