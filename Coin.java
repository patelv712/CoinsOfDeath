public final class Coin 
{
    private double width;
    private double height;
    private int x;
    private int y;
    //private boolean hasCollided;
    public Coin(double width, double height, int x, int y)
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
     public double getWidth() 
     {
        return this.width;
     }

    public double getHeight()
    {
        return this.height;
    }
    
    public int getX() 
    {
        return this.x;
    }
    
    public int getY() 
    {
        return this.y;
    }
}
