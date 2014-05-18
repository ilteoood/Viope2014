package group5.viope2014;

public class PacMan extends MobileElement
{
    private int defX, defY;
    public static final int defVulnereableTurns=5;
    private int vulnerableTurns;
    private boolean vulnerable=true;
        
    public PacMan(int x, int y, int turns)
    {
        super(new PacManBehaviour(x,y));
        defX=x;
        defY=y;
        this.vulnerableTurns=turns;
        super.move(x,y);
    }

    public void pillEat()
    {
        vulnerableTurns=defVulnereableTurns;
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