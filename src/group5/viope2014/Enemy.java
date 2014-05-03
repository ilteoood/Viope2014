package group5.viope2014;

public class Enemy extends MobileElement {

   private char name;

    public Enemy(char name, int x, int y) {

        this.name = name;
        super.move(x,y);

    }
}


