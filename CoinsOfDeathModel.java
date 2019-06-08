
import java.util.ArrayList;

public final class CoinsOfDeathModel {
    private TimeLimit time;
    private ArrayList<Coin> points = new ArrayList<Coin>();
    private Guy player;
    private int score;
    public CoinsOfDeathModel()
    {
    	this.time = new TimeLimit(java.time.Duration.ofMinutes(1));
    	for (int i = 0; i < 10; i ++)
    	{
    		int x = (int) Math.round(Math.random()*1200);
    		int y = (int) Math.round(Math.random()*750);
    		points.add(new Coin(50,50,x,y));
    	}
    	this.player = new Guy(50,50,0,0);
    	this.score = 0;
    	
    }
    private void removeCollidingCoins()
    {
        ArrayList<Coin> notColliding = new ArrayList<Coin>();
    	for (Coin coin : points)
    	{
    		double distance = Math.sqrt(Math.pow((player.getX() + player.getWidth()/2)  - (coin.getX() - coin.getWidth()/2), 2) + Math.pow(player.getY() - coin.getY(),2));
    		if (distance > 1)
    		{
    			notColliding.add(coin);
    		}
    	}
    	this.points = notColliding;
    }
    
    /*public Coin whichCoinColliding()
    {
    	int i = 0;
    	for (Coin e : points)
    	{
    		double distance = Math.sqrt(Math.pow((e.getX() + e.getWidth()/2)  - (points.get(i).getX() - points.get(i).getWidth()/2), 2) + Math.pow(e.getY() -points.get(i).getY(),2));
    		i++;
    		if (distance < 1)
    		{
    			return e;
    		}
    	}
    	return null;
    }*/
    public void moveUp(int amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveUp(amount);
        	this.score++;
        	this.removeCollidingCoins();
    	}

    }
    public void moveDown(int amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveDown(amount);
        	this.score++;
        	this.removeCollidingCoins();
    	}

    }
    public void moveRight(int amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveRight(amount);
        	this.score++;
        	this.removeCollidingCoins();
    	}

    }
    public void moveLeft(int amount)
    {
    	if (!time.timeUp())
    	{
        	this.player.moveLeft(amount);
        	this.score++;
        	this.removeCollidingCoins();
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
