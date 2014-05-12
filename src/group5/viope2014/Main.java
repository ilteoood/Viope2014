package group5.viope2014;

public class Main {

    public static void main(String[] args) {
        Maze field = new Maze("sometxtfile.txt");
        field.reload();
        while (field.getLives() > 0) { //add more conditionals
            field.move();
        }
        System.exit(0);
	// write your code here


    }
}
