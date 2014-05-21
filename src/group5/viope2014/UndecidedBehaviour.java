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
            int dir=4;
            if(x > Maze.pcX){
                dir = choseDirection.Move_Up;
            }
            else if(x < Maze.pcX){
                dir = choseDirection.Move_Down;
            }
            else if(y > Maze.pcY){
                dir = choseDirection.Move_Left;
            }
            else if(y < Maze.pcY){
                dir = choseDirection.Move_Right;
            }
            return dir;
        }
        return choseDirection.Move_StayHere;
    }
}
