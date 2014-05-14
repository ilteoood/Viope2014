package group5.viope2014;

public class Inky extends Enemy
{
    public Inky (int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
    @Override
    public String toString(){return "c";}   /* Return the symbol of Inky */
}
