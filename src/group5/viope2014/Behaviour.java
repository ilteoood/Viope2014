package group5.viope2014;

public abstract class Behaviour
{
    /*Fields*/
    private int oldX, oldY;
    private int direction=-1;
    private boolean nextIsInvalidPosition=false;

    public Behaviour()
    {

    }

    public Behaviour(int x,int y)
    {
        this.oldX=x;
        this.oldY=y;
    }

    public abstract int[] move(int dir,int nowX,int nowY);

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

    public void setNextInvalid(boolean status)
    {
        this.nextIsInvalidPosition=status;
    }
    public boolean getNextInvalid()
    {
        return this.nextIsInvalidPosition;
    }
    public abstract int getDirection();
    public abstract void setDirection(int dir);
    public abstract int getDefDirection();
    public abstract int getNextDir();
}
