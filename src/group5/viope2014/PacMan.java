package group5.viope2014;

public class PacMan extends MobileElement
{
    private int lifes=3, defX, defY;
    private int vulnerableTurns=5;
    private boolean vulnerable=true;
        
    public PacMan(int x, int y)
    {
        super(new PacManBehaviour(x,y));
        defX=x;
        defY=y;
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
        lifes-=(vulnerable==true?1:0);
    }

    public boolean isDead()
    {
        return lifes==0?true:false;
    }
    public int getDefX()
    {
        return this.defX;
    }

    public int getDefY()
    {
        return this.defY;
    }

    @Override
    public String toString(){return "X";}   /* Return the symbol of Pacman */
}