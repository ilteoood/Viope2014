package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pinky extends Enemy
{
    public Pinky (int x, int y)
    {
        super(new PinkyBehaviour(x,y,new FrightenedBehaviour()));
        super.move(x,y);
    }
    @Override
    public String toString(){return "p";}   /* Return the symbol of Pinky */

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/pinky.png"));
    }
}
