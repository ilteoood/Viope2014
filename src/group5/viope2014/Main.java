package group5.viope2014;

public class Main {

    public static void main(String[] args) {
        Maze field = new Maze("sometxtfile.txt");
        field.reload();
        field.printMaze();
        System.exit(0);
	// write your code here


    }
}
