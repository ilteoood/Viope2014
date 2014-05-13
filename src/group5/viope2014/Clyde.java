package group5.viope2014;

public class Clyde extends Enemy
{
    public Clyde(int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
}