import java.time.Duration;
public final class TimeLimit
{
    java.time.Duration timeRemaining;
    java.time.Duration timeTotal;

    public TimeLimit(java.time.Duration timeTotal) 
    {
        if (timeTotal == null) 
        {
            throw new IllegalArgumentException("Total time should not be null");
        }
        if (timeTotal.isNegative())
        {
            throw new IllegalArgumentException("Total time should not be negative");
        }
        this.timeRemaining = timeTotal;
        this.timeTotal = timeTotal;
    }
    public boolean timeUp()
    {
    	if (this.timeRemaining == Duration.ZERO) 
    	{
    		return true;
    	}
    	return false;
    }
    public void decreaseTime(long amount)
    {
    	if (this.timeRemaining.minus(Duration.ofMillis(amount)).isNegative())
    	{
    		this.timeRemaining = Duration.ZERO;    
    	}
    	this.timeRemaining = this.timeRemaining.minus(Duration.ofMillis(amount));
    }
    public java.time.Duration getRemaining()
    {
      return this.timeRemaining;
    }

    public java.time.Duration getTotal()
    {
      return this.timeTotal;
    }
}