package group5.viope2014;

public class PacMan extends MobileElement
{
    private int lifes=3;
    private int vulnerableTurns=5;
    private boolean vulnerable=true;
    private int points=0;
        
    public PacMan(int x, int y)
    {
        super(new PacManBehaviour());
        super.move(x,y);
        this.points=points;
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

    @Override
    public String toString(){return "X";}   /* Return the symbol of Pacman */
}