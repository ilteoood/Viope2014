package group5.viope2014;

public abstract class Behaviour
{
    /*Fields*/
    private int oldX, oldY;
    protected int x ;
    protected int y ;
    public boolean isAlive = true;
    public boolean gameOngoing = true;
    private int direction;

    public Behaviour()
    {}

    public void setDirection(int dir)
    {
        this.direction=dir;
    }

    public int getOldX() {
        return this.oldX;
    }

    public int getOldY() {
        return this.oldY;
    }

    public void setOldX(int x) {
        this.oldX = x;
    }

    public void setOldY(int y) {
        this.oldY = y;
    }
    
    public abstract int[] move(int dir);

    /*Methods*/
    abstract public int getNewX();

    abstract public int getNewY();
}
