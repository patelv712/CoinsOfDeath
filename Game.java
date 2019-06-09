import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener, KeyListener
{

    private static final long serialVersionUID = 1L;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int SCALE = 3;
    private CoinsOfDeathModel game = new CoinsOfDeathModel();
    int delay = 1000;
    private Timer timer = new Timer((1000/30) , this);
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    public Game()
    {
        super("Coins of Death");
        addKeyListener(this);
        this.game = new CoinsOfDeathModel();
    }
    public void view()
    {
        Canvas field = new Canvas(game);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        this.setVisible(true); //sets the visibility of the component. It is by default false.
        this.setFocusable(true);
        this.setResizable(false); //makes it so that the window size can not be adjusted
        this.pack(); //sizes the frame so that all its contents are at or above their preferred sizes.
        this.add(field);
        this.timer.start(); //calls actionPerformed
    }

    public static void main(String [] args)
    {
        Game x = new Game();
        x.view();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.game.decreaseTime(33);

        if (upPressed)
        {
            this.game.moveUp(10);
        }
        if(downPressed)
        {
            this.game.moveDown(10);
        }
        if(rightPressed)
        {
            this.game.moveRight(10);
        }
        if(leftPressed)
        {
            this.game.moveLeft(10);
        }

        this.repaint();

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
                upPressed = true;
                break;
            }
            case KeyEvent.VK_A:
            {
                leftPressed = true;
                break;
            }
            case KeyEvent.VK_S:
            {
                downPressed = true;
                break;
            }
            case KeyEvent.VK_D:
            {
                rightPressed = true;
                break;
            }
            default:
            {
                System.out.println("no mapping for this key");
                break;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
    }
}