package group5.viope2014;

public class PacMan extends MobileElement
{
    private int life=1;
    private int vulnerableTurns=5;
    private boolean vulnerable=true;
    private Behaviour bev;
    public PacMan(int x, int y, Behaviour p)
    {
        super.move(x,y);
        this.bev = p;
    }
    public void pillEat()
    {
        vulnerableTurns=5;
        vulnerable=false;
    }
    /* At every turn the number of the turn in which the ghosts are vulnerable decreases */
    public void decreaseTurns()
    {
        vulnerableTurns--;
        vulnerable=(vulnerableTurns==0?true:false);
    }
    public void decreaseLife()
    {
        life-=(vulnerable==true?1:0);
    }
    public boolean isDead()
    {
        return (life==0?true:false);
    }

}