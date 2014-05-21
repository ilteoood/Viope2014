package group5.viope2014;

/**
 * Created by Teo on 15/05/2014.
 */
public class EndGameException extends Exception
{
    public EndGameException(String s)
    {
        super(s);
        Music.playSoundDeath();
    }
}
