package group5.viope2014;

public abstract class MobileElement extends MazeElement
{
	/* Fields */
	private Behaviour bev;

    public MobileElement(){}

    public MobileElement(Behaviour b)
    {
        this.bev=b; // =)
    }

    public Behaviour getBehaviour()
    {
        return this.bev;
    }
}