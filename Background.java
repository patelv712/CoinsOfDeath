/*
*@author
*Varun P
*/
package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JComponent
	{
		BufferedImage myImage = null;
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g)
		{
			try
			{
				myImage = ImageIO.read(new URL("https://media.graytvinc.com/images/810*456/ice-web.jpg")); //used to handle image data
				super.paintComponent(g);
				g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), this); //use this not null bc when method called first time image has not been loaded yet so error if null
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	    }
	}
	
