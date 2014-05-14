package group5.viope2014;

public class Blinky extends Enemy
{
    public Blinky (int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
    @Override
    public String toString(){return "r";}   /* Return the symbol of Blinky */
}