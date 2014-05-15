package group5.viope2014;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Type path of file to open: ");
    	String file = sc.nextLine();
    	Maze field = new Maze(file);
    	System.out.println(field.toString());
    	field.printMaze();
    	field.newMaze();
    	System.out.print("System exit.");
    	System.exit(0);
    }

}
