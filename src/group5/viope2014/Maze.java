package group5.viope2014;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Dzar87 on 15.4.2014.
 */
public class Maze {

	private MazeElement[][] maze;
    private int  rows, columns, score, powerPillTurns, lives;
    private String filename;

    public Maze(String filename) {
        this.filename = filename;
        this.reload();
    }

    public String getFilename() {
        return this.filename;
    }
    
    public int getRows() {
    	return this.rows;
    }
    
    public int getColumns() {
    	return this.columns;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    void setMazeElement(int y, int x, MazeElement element) {
        this.maze[y][x] = element;
    }

    public MazeElement getMazeElement(int y, int x) {
        return this.maze[y][x];
    }

    public int getLives() {
        return this.lives;
    }

     @Override public String toString() {
        String currentConfig = "";
        String currentElement = maze[0][0].toString();    //Assuming every maze starts with a wall in the 0,0 position.
        int counter = 0;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (currentElement.compareTo(maze[i][j].toString()) == 0) {
                    counter++;
                    if (counter == 9) {
                    	currentConfig += (String.valueOf(counter) + currentElement);
                    	counter = 0;
                    }
                }
                else {
                    currentConfig += (String.valueOf(counter) + currentElement);
                    currentElement = maze[i][j].toString();
                    counter = 1;
                }
            }
            currentConfig += (String.valueOf(counter) + currentElement + "$");
            if (i == (this.rows - 1)) {
            	break;
            }
            counter = 0;
            currentElement = maze[i+1][0].toString();
        }
        return currentConfig;
    }
     
    public boolean isInteger(String str) {
    	try {
    		int i = Integer.parseInt(str);
    		return true;
    	} catch (NumberFormatException e) {
    		return false;
    	}
    }

    public void setMaze(String startConfig) {
        int y = 0, x = 0, counter = 1;
        char currentElement = 'W';
        while (y < this.rows) {
            for (int i = 0; i < startConfig.length(); i++) {
            	if (startConfig.charAt(i) == '$') {
                //if (Character.toString(startConfig.charAt(i)).equals("$")) {
                    y++;                                                            // if "$" then next row.
                    x = 0;                                                          // set X to the start of the row.
                    if (y == this.rows) {                                            // terminate the loop. each startConfig String should end with a "$", thus leading to a y == this.rows
                        break;
                    }
                    continue;
                }
                if (isInteger(Character.toString(startConfig.charAt(i)))) {
                	counter = Integer.parseInt(Character.toString(startConfig.charAt(i))); //Problem is here!!!
                }
                else {
                	currentElement = startConfig.charAt(i);
                	for (int j = x; j < x+counter;j++) {                            // Problem is here !!
            																		// Might throw IndexOutOfBoundsException
                        switch (currentElement) {                                   // Place holder cases for once the actual MazeElement and Behaviour classes work as intended
                            case 'X' : setMazeElement(y, j, new PacMan(j, y, this.powerPillTurns));
                                break;
                            case 'r' : setMazeElement(y, j, new Blinky(j, y));
                                break;
                            case 'p' : setMazeElement(y, j, new Pinky(j, y));
                                break;
                            case 'c' : setMazeElement(y, j, new Inky(j, y));
                                break;
                            case 'o' : setMazeElement(y, j, new Clyde(j, y));
                                break;
                            case 'P' : setMazeElement(y, j, new Pill(j, y));
                                break;
                            case 'd' : setMazeElement(y, j, new Dot(j, y));
                                break;
                            case 'W' : setMazeElement(y, j, new Wall(j, y));
                                break;
                            case '_' : setMazeElement(y, j, new Empty(j, y));
                                break;
                            default:
                            	break;
                        }
                	}
                	x+=counter;
                }
                

            }
        }
    }
    //Return a one-row string containing the config of the maze. powerPillTurns and lives are placeholders atm.
    public String getMaze() {
        return this.rows + "|" + this.columns + "|" + this.powerPillTurns + "|" + this.score +"|" + this.lives + "|" + toString();
    }

    public void write() {
        try {
            BufferedWriter output;
            output = new BufferedWriter((new FileWriter(this.filename, true)));
            output.newLine();
            output.append(getMaze());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reload() {
        String lastLine = "", currentLine;     //for easier debugging
        String[] vars;
        //Open the file and read until the EOF
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(this.filename));
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Split the lastLine per each "|"
        vars = lastLine.split("\\|");
        try {
            this.rows = Integer.parseInt(vars[0]);
            this.columns = Integer.parseInt(vars[1]);
            this.powerPillTurns = Integer.parseInt(vars[2]);
            this.score = Integer.parseInt(vars[3]);
            this.lives = Integer.parseInt(vars[4]);
            this.maze = new MazeElement[this.rows][this.columns];
            setMaze(vars[5]);
            //System.out.println(vars[5]);						//REMOVE THIS LATER!
        } catch (NumberFormatException e) {
            e.printStackTrace();								//in case the file stat config contains non-integers
        } catch (IndexOutOfBoundsException e) {                 //in case the file startConfig is different from this.rows and this.columns
            e.printStackTrace();
        }
    }

    public void backup(String file) {
        try {
            BufferedWriter output;
            output = new BufferedWriter(new FileWriter(file));
            output.write(getMaze());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Not touching this
    public void move() throws EndGameException {
        MazeElement mazE;
        for(int i=0;i<this.maze.length;i++)
        {
            for(int j=0;j<this.maze[i].length;j++)
            {
                mazE=this.maze[i][j];
                if(mazE instanceof PacMan)
                {
                    PacMan pac = (PacMan)mazE;
                    pac.decreaseTurns();
                    PacManBehaviour pacb = (PacManBehaviour)pac.getBehaviour();
                    int[] pos=checkWallforPacman(i,j,pacb);
                    if(this.maze[pos[0]][pos[1]]instanceof Enemy)
                    {
                        if(pac.isVulnerable())
                        {
                            this.lives--;
                            if(this.lives==0)
                            {
                                throw new EndGameException ("PacMan is dead!");
                            }
                            else
                            {
                                this.maze[i][j]=new Empty(i,j);
                                pac.move(pac.getDefY(), pac.getDefX());
                                pacb.setDirection(pacb.getDefDirection());
                                this.maze[pac.getDefY()][pac.getDefX()]=pac;
                                continue;
                            }
                        }
                    }
                    else if(this.maze[pos[0]][pos[1]] instanceof Pill)
                    {
                        pac.pillEat();
                        this.score+=Pill.getPoints();
                    }
                    else if(this.maze[pos[0]][pos[1]] instanceof Dot)
                    {
                        pac.pillEat();
                        this.score+=Dot.getPoints();
                    }
                    this.maze[pos[0]][pos[1]]=pac;
                    this.maze[i][j]=new Empty(i,j);
                    this.printMaze();
                }
                if(mazE instanceof Enemy)
                {
                    Enemy enem = (Enemy) mazE;
                    Behaviour b = enem.getBehaviour();
                    int pos[]=checkWallforEnemy(i,j,b);
                    if(this.maze[pos[0]][pos[1]] instanceof Pill)
                    {
                        enem.setOverleap();
                        enem.setType(Enemy.pill);
                        enem.setverleapPos(i,j);
                    }
                    this.maze[pos[0]][pos[1]]=enem;
                    int overpos[];
                    if(enem.getOverleap())
                    {
                        overpos=enem.getOverleapPos();
                        if(enem.getType()==Enemy.pill)
                            this.maze[overpos[0]][overpos[1]]=new Pill(overpos[0],overpos[1]);
                        else if(enem.getType()==Enemy.dot)
                            this.maze[overpos[0]][overpos[1]]=new Dot(overpos[0],overpos[1]);
                    }
                    else
                    {
                        this.maze[i][j] = new Empty(i, j);
                    }
                    this.printMaze();
                }
            }
        }
    }

    private int[] checkWallforEnemy(int i,int j,Behaviour bev)
    {
        int pos[]=bev.move(bev.getDirection(),i,j);
        while(this.maze[pos[0]][pos[1]] instanceof Wall||this.maze[pos[0]][pos[1]] instanceof Enemy||pos[0]>=this.maze.length||pos[1]>=this.maze[i].length)
        {
            pos=bev.move(bev.getNextDir(),i,j);
        }
        return  pos;
    }

    private int[] checkWallforPacman(int i,int j,Behaviour bev)
    {
        int pos[]=bev.move(bev.getDirection(),i,j);
        while(this.maze[pos[0]][pos[1]] instanceof Wall||pos[0]>=this.maze.length||pos[1]>=this.maze[i].length)
        {
            pos=bev.move(bev.getNextDir(),i,j);
        }
        return  pos;
    }
    
    public void printMaze() {
    	try {
    		System.out.printf("Score: %d\tLives: %d\tPowerTurns: %d\n", this.score, this.lives, this.powerPillTurns);
    		for (int i = 0; i < this.rows; i++) {
    			for (int j = 0; j < this.columns; j++) {
    				System.out.print(this.maze[i][j].toString());
    			}
    			System.out.println();
    		}
    	} catch (NullPointerException e) {
    		e.printStackTrace();
    	}
    }

    public void newMaze() {
    	String newConfiguration = null, userInput = null;
    	int[] conf = null;
    	try {
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Insert maze configuration {rows}|{columns}|{powerpillturns}|" +
    				"{score}|{lives}, 10|10|0|0|3|, : ");
    		newConfiguration = sc.nextLine();
    		if (newConfiguration.isEmpty()) {
    			return;
    		}
    		String[] input = newConfiguration.split("\\|");
    		conf = new int[input.length];
    		for (int i = 0; i < input.length;i++) {
    			conf[i] = Integer.parseInt(input[i]);
    		}
    		System.out.println("Insert the maze setup one symbol at a time, separating rows with a '$', WWWWWWWWW$WWWWW etc. : ");
    		userInput = sc.nextLine();
    		if (userInput.isEmpty()) {
    			return;
    		}
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    	} catch (NullPointerException e) {
    		e.printStackTrace();
    	}
    		
    	int y = 0, counter = 0;
    	char currentElement = userInput.charAt(0);
    	
    	while (y < conf[0]) {
    		for (int i = 0; i < userInput.length(); i++) {
    			if (userInput.charAt(i) == '$') {
    				y++;
    				newConfiguration += (String.valueOf(counter) + String.valueOf(currentElement) + "$");
    				counter = 0;
    				if (y == conf[0]) {
    					break;
    				}
    				currentElement = userInput.charAt(i+1);
    				continue;
    			}
    			else if (counter == 9) {
    				newConfiguration += (String.valueOf(counter) + String.valueOf(currentElement));
    				counter = 0;
    				currentElement = userInput.charAt(i+1);
    				continue;
    			}
    			else if (currentElement == userInput.charAt(i)) {
    				counter++;
    				continue;
    			}
    			else {
    				newConfiguration += (String.valueOf(counter) + String.valueOf(currentElement));
    				counter = 1;
    				currentElement = userInput.charAt(i);
    				continue;
    			}
    			
    			
    		}
    	}
    	System.out.println(newConfiguration);
    	System.out.println("Copy the above configuration into a file in order to run it.");
    }
}
