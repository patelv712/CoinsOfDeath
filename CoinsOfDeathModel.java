
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
