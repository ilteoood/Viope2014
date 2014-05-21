package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dot extends MazeElement
{
	public Dot(int x, int y) {super.move(x,y);}

    /* Override to prevent the movement of the Dot */
    @Override 
    public void move(int x, int y){}

    /* Return the offset =0 because the element can't be moved */
    @Override
    public int getHorizontalOffset(int x){return 0;}

    @Override
    public int getVerticalOffset(int y){return 0;}

    /* Return the symbol of the dot */
    @Override
    public String toString()
    {
        return "d";
    }

    public static int getPoints()
    {
        return 10; // Returns the value points of each dot
    }

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./white/dot.png"));
    }
}