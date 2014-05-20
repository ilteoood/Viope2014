package group5.viope2014;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Empty extends MazeElement
{
	public Empty(int x,int y){super.move(x,y);}

    /* Overridden to disable movement of the Empty */
    @Override 
    public void move(int x, int y) {}

    /* Return the symbol of Empty */
    @Override 
    public String toString() {return "_";}

    /* Return the offset =0 because the element can't be moved */
    @Override
    public int getHorizontalOffset(int x) {return 0;}

    @Override
    public int getVerticalOffset(int y) {return 0; }

    public static ImageView getPicture()
    {
        return new ImageView(new Image("./img/white/empty.png"));
    }
}