
import java.util.ArrayList;

public final class CoinsOfDeathModel {
    private TimeLimit time;
    private ArrayList<Coin> points = new ArrayList<Coin>();
    private Guy player;
    private int score;
    private AudioPlayer audio;
    public CoinsOfDeathModel()
    {
        this.time = new TimeLimit(java.time.Duration.ofMinutes(1));
        for (int i = 0; i < 10; i ++) //creates random location for 10 coins
        {
            int x = (int) Math.round(Math.random()*1200);
            int y = (int) Math.round(Math.random()*750);
            points.add(new Coin(50,50,x,y));
        }
        audio = new AudioPlayer();
        this.player = new Guy(50,50,0,0);
        this.score = 0;

    }
    private void handleCollisions()
    {
        ArrayList<Coin> noCollide = new ArrayList<Coin>();
        for (Coin coin : points) //iterates through each coin in the arrayList to check if it collides with the player
        {
            if (!this.player.isColliding(coin))
            {
                noCollide.add(coin);
            }
            
            if (this.player.isColliding(coin))
            {
            	this.audio.startCoinAudio();
            }
        }
        this.score += this.points.size() - noCollide.size();
        this.points = noCollide;

    } 
    public void moveUp(double amount)
    {
    	if (!time.timeUp() || this.score != 10)
    	{
            this.player.moveUp(amount);
            this.handleCollisions();
    	}
        this.manageSound();
    }
    public void moveDown(double amount)
    {
    	if (!time.timeUp() || this.score != 10)
    	{
            this.player.moveDown(amount);
            this.handleCollisions();
    	}
        this.manageSound();
    }
    public void moveLeft(double amount)
    {
    	if (!time.timeUp() || this.score != 10)
    	{
            this.player.moveLeft(amount);
            this.handleCollisions();
    	}
        this.manageSound();
    }
    public void moveRight(double amount)
    {
    	if (!time.timeUp() || this.score != 10)
    	{
            this.player.moveRight(amount);
            this.handleCollisions();
    	}
        this.manageSound();
    }
    public void manageSound()
    {
    	if (time.timeUp() && this.score < 10)
    	{
    		audio.stopBackgroundAudio();
        	audio.startSadGameOverAudio();
    	}
    	if (time.timeUp() && this.score == 10)
    	{
    		audio.stopBackgroundAudio();
        	audio.startHappyGameOverAudio();
    	}
    }
    public void decreaseTime(long amount)
    {
        time.decreaseTime(amount);
    }
    public AudioPlayer getAudio()
    {
    	return audio;
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
