package group5.viope2014;
public class Pill extends MazeElement
{
    private static int points=50;
    private boolean vulnerable=false;
    private int vulnerableTurns=5;
	public Pill()
	{}
    public void pillEat()
    {
        vulnerableTurns=5;
        vulnerable=true;
    }
    public void reduceTurns()
    {
        vulnerableTurns--;
        vulnerable=(vulnerableTurns==0?false:true);
    }
}