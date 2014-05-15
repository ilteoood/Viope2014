package group5.viope2014;

public class Enemy extends MobileElement 
{
    public static final int pill=0x0;
    public static final int dot=0x1;
    private boolean overleap=false;
    private int type=-1;
    private int[] overPos={-1,-1};
	public Enemy (Behaviour bev)
	{
		super(bev);
	}

    public boolean getOverleap()
    {
        this.overleap=false;
        return this.overleap;
    }

    public void setOverleap()
    {
        this.overleap=true;
    }

    public void setverleapPos(int x, int y)
    {
        this.overPos[0]=x;
        this.overPos[1]=y;
    }

    public int[] getOverleapPos()
    {
        return this.overPos;
    }

    public void setType(int type)
    {
        this.type=type;
    }

    public int getType()
    {
        return this.type;
    }
}