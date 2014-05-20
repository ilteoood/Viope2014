package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Inky extends Enemy
{
    public Inky (int x, int y)
    {
        super(new InkyBehaviour(x,y));
        super.move(x,y);
    }
    @Override
    public String toString(){return "c";}   /* Return the symbol of Inky */

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/inky.png"));
    }
}
