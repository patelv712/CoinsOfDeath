
import java.util.ArrayList;

public final class CoinsOfDeathModel {
    private TimeLimit time;
    private ArrayList<Coin> points = new ArrayList<Coin>();
    private Guy player;
    private int score;
    public CoinsOfDeathModel()
    {
    	this.time = new TimeLimit(java.time.Duration.ofMinutes(1));
    	for (int i = 0; i < 10; i ++) //creates random location for 10 coins
    	{
    		int x = (int) Math.round(Math.random()*1200);
    		int y = (int) Math.round(Math.random()*750);
    		points.add(new Coin(50,50,x,y));
    	}
    	this.player = new Guy(50,50,0,0);
    	this.score = 0;
    	
    }
   private void handleCollisions()
    {
    	ArrayList<Coin> noCollide = new ArrayList<Coin>();
    	for (Coin coin : points) //iterates through each coin in the arrayList to check if it collides with the player
    	{
    	
    		double distance = Math.sqrt(Math.pow((player.getX() + player.getWidth()/2)  - (coin.getX() - coin.getWidth()/2), 2) + Math.pow(player.getY() - coin.getY(),2));
    		if (distance > 90)
    		{
    			noCollide.add(coin);
    		}
    		else
    		{
    			this.score = this.points.size() - noCollide.size();
    			this.points = noCollide;
    		}
    	}
    	
    }
    public void moveUp(double amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveUp(amount);
        	this.handleCollisions();
    	}

    }
    public void moveDown(double amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveDown(amount);

        	this.handleCollisions();
    	}

    }
    public void moveRight(double amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveRight(amount);
        	this.handleCollisions();
    	}

    }
    public void moveLeft(double amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveLeft(amount);
        	this.handleCollisions();
    	}

    }
    public void decreaseTime(long amount)
    {
    	time.decreaseTime(amount);
    }
    public TimeLimit getTime()
    {   
        return this.time;
    }
    public Guy getPlayer()
    {
        return this.player;
    }
    public ArrayList<Coin> getPoints()
    {
        return this.points;
    }
    public int getScore()
    {
        return this.score;
    }
}
