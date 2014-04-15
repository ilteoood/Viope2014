package group5.viope2014;
public class Dot extends MazeElement
{
	private static int dotsPoint=10;

	public Dot(int x, int y) {super.move(x,y);}

    /* Override to prevent the movement of the Dot */
    @Override public void move(int x, int y){}

    /* Return the offset =0 because the element can't be moved */
    public int getHorizontalOffset(){return 0;}
    public int getVerticalOffset(){return 0;}

    /* Return the symbol of the dot */
    public String ToString(){return "d";}

    public int getPoints() {return dotsPoint;}
}