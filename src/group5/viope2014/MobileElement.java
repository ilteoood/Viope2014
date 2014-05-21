package group5.viope2014;

public abstract class MobileElement extends MazeElement
{
	/* Fields */
	private Behaviour bev;
    private boolean dead=false;
	private boolean moved;
	

    public MobileElement(){}

    public MobileElement(Behaviour b)
    {
        this.bev=b; // =)
    }

    public Behaviour getBehaviour()
    {
        return this.bev;
    }

    public void setDead()
    {
        this.dead=true;
    }

    public boolean getDead()
    {
        boolean tmp=this.dead;
        this.dead=false;
        return tmp;
    }
	public boolean hasMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}