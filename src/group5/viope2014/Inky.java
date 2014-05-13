package group5.viope2014;

public class Inky extends MobileElement
{
    public Inky (int x, int y, Behaviour b)
    {
        super(b);
        super.move(x,y);
    }
}
