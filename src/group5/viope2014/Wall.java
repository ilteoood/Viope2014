package group5.viope2014;
public class Wall extends MazeElement
{
	public Wall() {

    }

    /* Overridden to disable movement of the Wall MazeElement. */
    @Override public void move(int x, int y) {

    }
    /* As per the instructions for the Maze class. */
    @Override public String toString() {
        return "W";
    }

    /*Placeholders*/
    public int getHorizontalOffset() {
        return 0;
    }
    public int getVerticalOffset() {
        return 0;
    }
}