package group5.viope2014;

public class Blinky extends Enemy
{
    public Blinky (int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
}