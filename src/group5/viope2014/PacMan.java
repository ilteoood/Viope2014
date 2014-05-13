package group5.viope2014;

public class PacMan extends MobileElement
{
    private boolean isAlive=true;
    private int vulnerableTurns=5;
    private boolean vulnerable=true;
        
    public PacMan(int x, int y, Behaviour bev)
    {
        super(bev);
        super.move(x,y);
    }

    public void pillEat()
    {
        vulnerableTurns=5;
        vulnerable=false;
    }

    /* At every turn the number of the turn in which the ghosts are vulnerable decreases */
    public void decreaseTurns()
    {
        vulnerable=(vulnerableTurns--==0?true:false);
    }

    public boolean isVulnerable()
    {
        return this.vulnerable;
    }

    public void decreaseLife()
    {
        this.isAlive=(vulnerable==true?false:true);
    }

    public boolean isDead()
    {
        return (this.isAlive==true?false:true);
    }
}