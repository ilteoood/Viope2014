package group5.viope2014;

public class Main
{

    public static void main(String[] args) {
    	Maze field = new Maze("filename.txt");
    	System.out.println(field.toString());
    	field.printMaze();
    	field.write();
    	field.reload();
    	field.printMaze();
    	System.exit(0);
    }

}
