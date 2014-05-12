package group5.viope2014;

/**
 * Created by Anne on 04/04/14.
 */
public abstract class Behaviour {

    /*Fields*/
    private static int oldX, oldY;
    //private int x = MazeElement.getX();
    ///private int y = MazeElement.getY();
    public boolean isAlive = true;
    public boolean gameOngoing = true;




    /*
    switch() {
        case direction = left;
            MazeElement.move(x-1, y)
            x = x-1;
            y = y;
        case direction = right;
            MazeElement.move(x+1, y)
            x = x+1;
            y = y;
        case direction = down;
            MazeElement.move(x, y-1)
            x = x;
            y = y-1;
        case direction = up;
            MazeElement.move(x, y+1)
            x = x;
            y = y+1;
    }
    */

    /*Methods*/
    abstract public int getNewX();

    abstract public int getNewY();

    public void moveAhead() {
    }

    ;

    public void turnLeft() {
    }

    ;

    public void turnRight() {
    }

    ;

}
