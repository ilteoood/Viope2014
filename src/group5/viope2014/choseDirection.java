package group5.viope2014;

public class choseDirection
{
    /*
    Legend about the movement, array index:
    - 0, right
    - 1, left
    - 2, up
    - 3, down
    */
    private static final int x[]={1,-1,0,0};
    private static final int y[]={0,0,1,-1};
    public static int[] getMovement(int dir)
    {
        int ret[]=new int[2];
        ret[0]=x[dir];
        ret[1]=y[dir];
        return ret;
    }
}