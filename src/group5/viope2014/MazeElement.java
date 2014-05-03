package group5.viope2014;

import java.lang.UnsupportedOperationException;

public abstract class MazeElement
{
	private int x,y;

	public void move (int x,int y)
	{
        this.x=x;
        this.y=y;
    }

	public String toString()
	{
        return "Position: ("+this.x+","+this.y+")";
    }

	//public abstract int getHorizontalOffset();
	//public abstract int getVerticalOffset();

    public int getValue() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("The current element doesn't have a score!\nOverride before use!");
    }

    //not needed, but can me useful
	public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}