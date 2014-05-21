package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Blinky extends Enemy
{
    public Blinky (int x, int y)
    {
        super(new BlinkyBehaviour(x,y,new ChaseBehaviour()));
        super.move(x,y);
    }
    @Override
    public String toString(){return "r";}   /* Return the symbol of Blinky */

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/blinky.png"));
    }
}