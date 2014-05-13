package group5.viope2014;

public abstract class Behaviour
{
    /*Fields*/
    private int oldX, oldY;
    private int direction=-1;

    public Behaviour()
    {}

    public abstract int[] move(int dir);

    public int getOldX() 
    {
        return this.oldX;
    }

    public int getOldY() 
    {
        return this.oldY;
    }

    public void setOldX(int x) 
    {
        this.oldX = x;
    }

    public void setOldY(int y) 
    {
        this.oldY = y;
    }

    public abstract int getDirection();
    public abstract void setDirection(int dir);
    public abstract int getDefDirection();
}
