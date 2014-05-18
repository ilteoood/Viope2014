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
        this.dead=!this.dead;
        return !this.dead;
    }
	public boolean hasMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}