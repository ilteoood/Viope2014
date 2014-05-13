package group5.viope2014;

public class BlinkyBehaviour extends Behaviour
{
    private int direction = choseDirection.Move_Left;

    @Override
    public int[] move(int dir)
    {
        int[] directionArray=choseDirection.getMovement(dir);
        return new int[]{directionArray[0]+super.getOldX(),directionArray[1]+super.getOldY()};
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
}
