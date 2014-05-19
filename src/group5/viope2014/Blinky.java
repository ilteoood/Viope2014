package group5.viope2014;

public class Blinky extends Enemy
{
    public Blinky (int x, int y)
    {
        super(new BlinkyBehaviour(x,y,new RandomMove()));
        super.move(x,y);
    }
    @Override
    public String toString(){return "r";}   /* Return the symbol of Blinky */
}