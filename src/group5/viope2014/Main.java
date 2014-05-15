package group5.viope2014;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char userInput = '0';
    	String file = null;
    	Maze field = null;
    	while (userInput != '4') {
    		System.out.print("\n1\tLoad\n2\tSave\n3\tMaze \"Editor\"\n\n4\tExit\n");
    		try {
    			userInput = sc.nextLine().charAt(0);
    		}
    		catch (StringIndexOutOfBoundsException e) {
    			userInput = '0';
    		}
    		switch (userInput) {
    			case '1': 	//ADD cls here
    						System.out.println("Type path of file to open: ");
    						file = sc.nextLine();
    						field = new Maze(file);
    						field.printMaze();
					break;
    			case '2':	field.write();
    					 	field.backup("backup.txt");
    					 	System.out.println("\nGame saved in " + "\"" + field.getFilename() + "\"");
				 	break;
    			case '3' : 	//ADD cls here
    						field.newMaze();
    				break;
    			case '4' : 	//ADD cls here
    						System.out.println("Bye, bye!");
    						System.exit(0);
    				break;
				default:
					break;
    		}
    		//ADD cls here
    	}
    	
    }

}
