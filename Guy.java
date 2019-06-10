import java.awt.*;
import java.awt.geom.Rectangle2D;

public final class Guy
{
    private double width;
    private double height;
    private double x;
    private double y;
    AudioPlayer a = new AudioPlayer();
    public Guy(double width, double height, double x, double y)
    {
        if (height <= 0 || width <= 0)
        {
            throw new IllegalArgumentException("Height/Width should not be negative/Zero !");
        }
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    public void moveUp(double amount)
    {
        this.y -= amount;
    }

    public void moveRight(double amount)
    {
        this.x += amount;
    }

    public void moveLeft(double amount)
    {
        this.x -= amount;
    }

    public void moveDown(double amount)
    {
        this.y +=amount;
    }

    public double getWidth()
    {
        return this.width;
    }

    public double getHeight()
    {
        return this.height;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public boolean isColliding(Coin coin) {
        Rectangle2D thisShape = new java.awt.geom.Rectangle2D.Double(this.x, this.y, this.width, this.height);
        Rectangle2D otherShape = new java.awt.geom.Rectangle2D.Double(coin.getX(), coin.getY(), coin.getWidth(), coin.getHeight());
        return thisShape.intersects(otherShape);

    }
}
