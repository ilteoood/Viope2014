package group5.viope2014;

public class Enemy extends MobileElement 
{
    public static final int pill=0x0;
    public static final int dot=0x1;
    private boolean overleap=false;
    private int type=-1;
	public Enemy (Behaviour bev)
	{
		super(bev);
	}

    public boolean getOverleap()
    {
        return this.overleap;
    }

    public void setOverleap()
    {
        this.overleap=true;
    }

    public void resetOverleapPos()
    {
        this.overleap=false;
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