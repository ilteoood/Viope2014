package group5.viope2014;

public class PacManBehaviour extends Behaviour
{
    public PacManBehaviour(){}

    @Override
    public int[] move(int dir)
    {
        int[] directionArray=choseDirection.getMovement(dir);
        return new int[]{directionArray[0]+super.getOldX(),directionArray[1]+super.getOldY()};
    }

    public int getNewX()
    {
        return 0;
    }

    public int getNewY()
    {
        return 0;
    }
}
