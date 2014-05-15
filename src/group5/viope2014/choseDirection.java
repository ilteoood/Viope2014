package group5.viope2014;

public class choseDirection
{
    // Direction:
    public static final int Move_Right=0;
    public static final int Move_Left=1;
    public static final int Move_Up=2;
    public static final int Move_Down=3;

    private static final int x[]={0,0,-1,1};
    private static final int y[]={1,-1,0,0};
    public static int[] getMovement(int dir)
    {
        int ret[]=new int[2];
        ret[0]=x[dir];
        ret[1]=y[dir];
        return ret;
    }
}