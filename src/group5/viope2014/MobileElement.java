package group5.viope2014;
public abstract class MobileElement extends MazeElement
{
	// Fields
	protected Behaviour bev;

    //Sets the object's behaviour to b
    public void setBehaviour(Behaviour b){
        this.bev = b;
    }

    //Returns the object's behaviour
    public Behaviour getBehaviour(){
        return this.bev;
    }
}