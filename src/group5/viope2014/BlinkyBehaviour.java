package group5.viope2014;

public class BlinkyBehaviour extends Behaviour
{
    private int direction = choseDirection.Move_Left;
    private ArtificialIntelligence pattern;
    
    public BlinkyBehaviour(int x,int y, ArtificialIntelligence pattern)
    {
        super(x,y);
        this.pattern = pattern;
    }

    @Override
    public int[] move(int dir, int nowX, int nowY)
    {
    	
        int[] directionArray=choseDirection.getMovement(this.pattern.intMove(0, 0));
        super.setOldX(nowX);
        super.setOldY(nowY);
        return new int[]{directionArray[0]+nowX,directionArray[1]+nowY};
    }

    @Override
    public int getDirection()
    {
        return this.direction;
    }

    @Override
    public void setDirection(int dir)
    {
        this.direction=dir;
    }

    @Override
    public int getDefDirection()
    {
        return choseDirection.Move_Left;
    }

    @Override
    public int getNextDir()
    {
        switch(this.direction)
        {
            case choseDirection.Move_Left:
                this.direction=choseDirection.Move_Down;
                break;
            case choseDirection.Move_Right:
                this.direction=choseDirection.Move_Up;
                break;
            case choseDirection.Move_Up:
                this.direction=choseDirection.Move_Left;
                break;
            case choseDirection.Move_Down:
                this.direction=choseDirection.Move_Right;
                break;
        }
        return this.direction;
    }
}
