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
    		System.out.print("\n1\tLoad\n2\tSave\n3\tMaze \"Editor\"\n4\tExit\n");
    		try {
    			userInput = sc.nextLine().charAt(0);
    		}
    		catch (StringIndexOutOfBoundsException e) {
    			userInput = '0';
    		}
			try
			{
				switch (userInput) {
					case '1':
					    //ADD cls here
					    System.out.println("Type path of file to open: ");
						file = sc.nextLine();
						if(file.equals("-")){
							file="testMazes/emptyMaze.txt";
						}
						field = new Maze(file);
						System.out.println("Initial config :");
						field.printMaze();
						System.out.println("Game Starts :");
						while(true)
						{		
                            field.move();
                            System.out.println("Press enter to continue ...");
                            sc.nextLine();
                        }
					case '2':
                        field.write();
						field.backup("backup.txt");
						System.out.println("\nGame saved in " + "\"" + field.getFilename() + "\"");
						break;
					case '3' :
					//ADD cls here
					field.newMaze();
					break;
					case '4' :
					//ADD cls here
					System.out.println("Bye, bye!");
					System.exit(0);
					break;
				}
			}
			catch(EndGameException e)
			{
				System.out.println("Game ended!");
			}
    		//ADD cls here
    	}
    	
    }

}
