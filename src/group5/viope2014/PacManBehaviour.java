package group5.viope2014;

public class PacManBehaviour extends Behaviour
{
    private int direction = choseDirection.Move_Right;

    public PacManBehaviour(int x,int y)
    {
        super(x,y);
    }

    @Override
    public int[] move(int dir,int nowX,int nowY)
    {
        int[] directionArray=choseDirection.getMovement(dir);
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
        return choseDirection.Move_Right;
    }

    @Override
    public int getNextDir()
    {
        switch(this.direction)
        {
            case choseDirection.Move_Left:
                this.direction=choseDirection.Move_Up;
                break;
            case choseDirection.Move_Right:
                this.direction=choseDirection.Move_Down;
                break;
            case choseDirection.Move_Up:
                this.direction=choseDirection.Move_Right;
                break;
            case choseDirection.Move_Down:
                this.direction=choseDirection.Move_Left;
                break;
        }
        return this.direction;
    }
}
