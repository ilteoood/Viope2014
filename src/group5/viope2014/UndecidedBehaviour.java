package group5.viope2014;

import java.util.Random;

public class UndecidedBehaviour implements ArtificialIntelligence
{
    @Override
    public int intMove(int x, int y)
    {
        Random rnd = new Random();
        int r = rnd.nextInt(51);
        if(r>30&&r<43)
            return rnd.nextInt(4);
        else if(r>15&&r<29)
        {
            int xD = x - Maze.pcX;
            int yD = y - Maze.pcY;
            int dir=-1;
            if(xD > 0){
                dir = choseDirection.Move_Up;
            }
            else if(xD < 0){
                dir = choseDirection.Move_Down;
            }
            else if(yD > 0){
                dir = choseDirection.Move_Left;
            }
            else if(yD < 0){
                dir = choseDirection.Move_Right;
            }
            return dir;
        }
        return choseDirection.Move_StayHere;
    }
}
