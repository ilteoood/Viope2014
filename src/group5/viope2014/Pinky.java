package group5.viope2014;

public class Pinky extends Enemy
{
    public Pinky (int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
    @Override
    public String toString(){return "p";}   /* Return the symbol of Pinky */
}
