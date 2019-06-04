import java.util.ArrayList;

public final class CoinsOfDeathModel {
    private TimeLimit time;
    private ArrayList<Coin> points ;
    private Guy player;
    private int score;
    
    public TimeLimit getTime()
    {   
        return time;
    }
    public Guy getPlayer()
    {
        return player;
    }
    public ArrayList<Coin> getPoints()
    {
        return points;
    }
    public int getScore()
    {
        return score;
    }
}
