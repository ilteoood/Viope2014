package group5.viope2014;

public class Wall extends MazeElement
{
	public Wall(int x, int y) 
    {
        super.move(x,y);
    }

    /* Overridden to disable movement of the Wall */
    @Override 
    public void move(int x, int y) {}

    /* Return the symbol of Power Pill */
    @Override 
    public String toString() 
    {
        return "W";
    }

    /* Return the offset =0 because the element can't be moved */
    public int getHorizontalOffset() {return 0;}
    public int getVerticalOffset() {return 0; }
}