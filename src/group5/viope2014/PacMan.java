package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PacMan extends MobileElement
{
    private int defX, defY;
    public static final int defVulnereableTurns=5;
    private int vulnerableTurns;
    private boolean vulnerable=true;
        
    public PacMan(int x, int y, int turns)
    {
        super(new PacManBehaviour(x,y));
        this.vulnerableTurns=turns;
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
        if(this.vulnerableTurns>=0)
            this.vulnerable=(this.vulnerableTurns--<=0?true:false);
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

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/pacmanleft.png"));
    }
}