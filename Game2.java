import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;

public class Game2 extends JFrame
{

	private static final long serialVersionUID = 1L;
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private final int SCALE = 3;
	private CoinsOfDeathModel game = new CoinsOfDeathModel();
	Canvas field = new Canvas(game);
	public Game2() throws MalformedURLException, IOException
	{
		super("Coins of Death");
		this.game = new CoinsOfDeathModel();
		}
	public void view()
	{
		
		this.setLocation(100, 100); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		this.setVisible(true); //sets the visibility of the component. It is by default false.
		this.setFocusable(true);  
		this.setResizable(false); //makes it so that the window size can not be adjusted
		this.pack(); //sizes the frame so that all its contents are at or above their preferred sizes.
		this.add(field);
	}
	
	public static void main(String [] args) throws MalformedURLException, IOException
	{
		Game2 x = new Game2();
		x.view();
	}
}
