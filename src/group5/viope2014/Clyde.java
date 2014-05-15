package group5.viope2014;

public class Clyde extends Enemy
{
    public Clyde(int x, int y)
    {
        super(new ClydeBehaviour(x,y));
        super.move(x,y);
    }
    @Override
    public String toString(){return "o";}   /* Return the symbol of Clyde */
}