package group5.viope2014;
public class Empty extends MazeElement
{
	public Empty(int x,int y){super.move(x,y);}

    /* Overridden to disable movement of the Empty */
    @Override public void move(int x, int y) {}

    /* Return the symbol of Empty */
    @Override public String toString() {return " ";}

    /* Return the offset =0 because the element can't be moved */
    public int getHorizontalOffset() {return 0;}
    public int getVerticalOffset() {return 0; }
}