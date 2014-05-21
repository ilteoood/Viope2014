package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Clyde extends Enemy
{
    public Clyde(int x, int y)
    {
        super(new ClydeBehaviour(x,y,new ChaseBehaviour()));
        super.move(x,y);
    }
    @Override
    public String toString(){return "o";}   /* Return the symbol of Clyde */

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/clyde.png"));
    }
}