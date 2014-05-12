package group5.viope2014;
/**
 * Created by Anne on 04/04/14.
 */
/* Reviewed by iLTeoooD & JDL */
public abstract class Behaviour {

    /*Fields*/
    private int oldX, oldY;
    private int x ;
    private int y ;
    private MazeElement mazeE;
    public boolean isAlive = true;
    public boolean gameOngoing = true;

    public Behaviour(MazeElement mazeEl)
    {
        this.mazeE=mazeEl;
        this.x=mazeEl.getX();
        this.y=mazeEl.getY();
    }
    
    public void move(char direction)
    {
        switch (direction)
        {
            case 'l':
                this.oldX=x;
                x--;
                mazeE.move(x, y);
                break;
            case 'r':
                this.oldX=x;
                x++;
                mazeE.move(x, y);
                break;
            case 'd':
                this.oldY=y;
                y--;
                mazeE.move(x, y);
                break;
            case 'u':
                this.oldY=y;
                y++;
                break;
            default:
                System.out.println("Something went wrong");
        }
    }

    /*Methods*/
    abstract public int getNewX();

    abstract public int getNewY();

}
