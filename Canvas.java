import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Canvas extends JComponent
{
	private static final long serialVersionUID = 1L;
	private BufferedImage background = null;
	private BufferedImage playerIcon = null;
	//private BufferedImage coinPic = null;
	private CoinsOfDeathModel state = null;
	private int xC = (int) state.getPlayer().getX(); //xCoordinate of the player
	private int yC = (int) state.getPlayer().getY(); //yCoordinate of the player
	public Canvas(CoinsOfDeathModel state) 
	{
		try
		{
			//this.coinPic = ImageIO.read(new URL("https://previews.123rf.com/images/rastudio/rastudio1802/rastudio180200842/96362871-gold-dollar-coin-circle-coin-with-dollar-symbol-isolated-on-transparent-background-means-of-payment-.jpg"));
			this.background = ImageIO.read(new URL("https://www.pennington.com/-/media/images/pennington-na/us/blog/seed/all-you-need-to-know-about-bermudagrass/bermuda-header.jpg"));
			this.state = state;
			this.playerIcon = ImageIO.read(new URL("https://images-na.ssl-images-amazon.com/images/I/61O3LuvpDML._SY355_.png"));
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	} 
	public void paintComponent(Graphics g)
	{
		try 
		{
			
			super.paintComponent(g);
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this); //use this not null bc when method called first time image has not been loaded yet so error if null
			g.setColor(Color.YELLOW);
			for (int i = 0; i < state.getPoints().size(); i++)
			{
				//g.drawImage(coinPic, state.getPoints().get(i).getX(), state.getPoints().get(i).getY(), 50, 50, new Color(0,0,0,0), this);
				g.fillRoundRect(state.getPoints().get(i).getX(), state.getPoints().get(i).getY(), 50, 50, 50, 50);
			}
			g.drawImage(playerIcon, xC,yC, 150, 150,  new Color(0,0,0,0), this);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 72)); 
			g.drawString(Long.toString(state.getTime().getRemaining().getSeconds()), (this.getWidth()/2) -100, 100);
			g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, 150);
			g.drawString(Integer.toString(state.getScore()), (this.getWidth()/2) + 50, 100);
			
		} 
		catch (Exception e) 
		{
			
			throw new RuntimeException(e);
		}
	}
}
