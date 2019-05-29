package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent evt)
	{
		
		int key = evt.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_W:
			{
				//yC--;
				System.out.println("" + evt.getKeyChar());  //for testing purposes
				break;
			}
			case KeyEvent.VK_A:
			{
				//xC--;
				System.out.println("" + evt.getKeyChar());
				break;
			}
			case KeyEvent.VK_S:
			{
				//yC++;
				System.out.println("" + evt.getKeyChar());
				break;
			}
			case KeyEvent.VK_D:
			{
				//xC++;
				System.out.println("" + evt.getKeyChar());
				break;
			}
			/*default:
			{
				System.out.println("bruhhhh");
				break;
			}*/
		}
		//x.drawImage(guy,xC,yC, h, w,  new Color(0,0,0,0), y)	;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}
}
