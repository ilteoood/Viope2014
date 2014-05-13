package group5.viope2014;
public class Pill extends MazeElement
{
    private final static int points=50;
    private boolean vulnerable=false;

	public Pill(int x, int y) {super.move(x,y);}

    /* Override to prevent the movement of the Pill */
    @Override public void move(int x, int y){}

    /* Set if the ghosts are vulnerable and restore the number of the turn which they are vulnerable to 5 */



    /* Set the offset =0 because the element can't be moved */
    @Override public int getHorizontalOffset(int x){return 0;}
    @Override public int getVerticalOffset(int y){return 0;}

    public String ToString(){return "P";}   /* Return the symbol of Power Pill */
}