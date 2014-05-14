package group5.viope2014;

import java.io.*;

/**
 * Created by Dzar87 on 15.4.2014.
 */
public class Maze {

	private MazeElement[][] maze;
    private int  rows, columns, score, powerPillTurns, lives;
    private String filename;

    public Maze(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    void setMazeElement(int y, int x, MazeElement element) {
        this.maze[y][x] = element;
    }

    MazeElement getMazeElement(int y, int x) {
        return this.maze[y][x];
    }

    public int getLives() {
        return this.lives;
    }

     @Override public String toString() {
        String currentConfig = "";
        String currentElement = "W";    //Assuming every maze starts with a wall in the 0,0 position.
        int counter = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentElement.compareTo(maze[i][j].toString()) == 0) {
                    counter++;
                }
                else {
                    currentConfig += String.valueOf(counter) + currentElement;
                    currentElement = maze[i][j].toString();
                    counter = 1;
                }

            }
            currentConfig += "$";
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
            	//if (startConfig.charAt(i) == '\$') {
                if (Character.toString(startConfig.charAt(i)).equals("$")) {
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
                            case 'X' : setMazeElement(y, j, new PacMan(j, y));
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
        } catch (NumberFormatException e) {
            e.printStackTrace();
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
    public void move() {
    /*    MazeElement tmpNewBlinky = new Empty(), tmpOldBlinky = new Dot();
        MazeElement tmpNewPinky = new Empty(), tmpOldPinky = new Dot();
        MazeElement tmpNewInky = new Empty(), tmpOldInky = new Dot();
        MazeElement tmpNewClyde = new Empty(), tmpOldClyde = new Dot();
        int newX = 0, newY = 0;
        for (int i = 0; i<this.columns;i++) {
            for (int j = 0; j<this.rows; j++) {


                if (this.maze[i][j] instanceof Enemy.Blinky) {
                    newY = this.maze[i][j].bev.getNewY();
                    newX = this.maze[i][j].bev.getNewX();
                    tmpNewBlinky = getMazeElement(newY,newX);
                    if (tmpNewBlinky instanceof PacMan) {

                        this.lives--;
                        setMazeElement(i, j, new Empty(j, i));
                    }
                    else {
                        setMazeElement(i, j, tmpOldBlinky);
                        //this.maze[i][j] = tmpOldBlinky;
                        tmpOldBlinky = tmpNewBlinky;
                        setMazeElement(newY, newX, new Enemy().new Blinky(newX, newY, new BlinkyBehaviour(), 'r'));
                    }
                }









                else if (this.maze[i][j] instanceof Enemy.Pinky) {
                    newY = this.maze[i][j].getNewY();
                    newX = this.maze[i][j].getNewx();
                    tmpNewPinky = getMazeElement(newY,newX);
                    if (tmpNewPinky instanceof PacMan) {
                        this.lives--;
                        this.maze[i][j] = new Empty();
                    }
                    else {
                        setMazeElement(i, j, tmpOldPinky);
                        //this.maze[i][j] = tmpOldPinky;
                        tmpOldPinky = tmpNewPinky;
                        setMazeElement(newY, newX, new Enemy.Pinky('p', new PinkyBehaviour()));
                    }
                }
                else if (this.maze[i][j] instanceof Enemy.Inky) {
                    newY = this.maze[i][j].getNewY();
                    newX = this.maze[i][j].getNewx();
                    tmpNewInky = getMazeElement(newY,newX);
                    if (tmpNewInky instanceof PacMan) {
                        this.lives--;
                        this.maze[i][j] = new Empty();
                    }
                    else {
                        setMazeElement(i, j, tmpOldInky);
                        //this.maze[i][j] = tmpOldInky;
                        tmpOldInky = tmpNewInky;
                        setMazeElement(newY, newX, new Enemy.Inky('c', new InkyBehaviour());
                    }
                }
                else if (this.maze[i][j] instanceof Enemy.Clyde) {
                    newY = this.maze[i][j].getNewY();
                    newX = this.maze[i][j].getNewx();
                    tmpNewClyde = getMazeElement(newY, newX);
                    if (tmpNewClyde instanceof PacMan) {
                        this.lives--;
                        this.maze[i][j] = new Empty();
                        setMazeElement(i, j, new Empty());
                    }
                    else {
                        setMazeElement(i, j, tmpOldClyde);
                        //this.maze[i][j] = tmpOldClyde;
                        tmpOldClyde = tmpNewClyde;
                        setMazeElement(newY, newX, new Enemy.Clyde('o', new ClydeBehaviour());
                    }
                }
                else {


                }
            }
        }
    }
    boolean newCoords(MobileElement mob) {
        switch (mob.bev.getBehaviour())
        {
            case 'l':
                //DO NOT TOUCH THIS!!!!
                if (mob.getHorizontalOffset(mob.bev.getOldX()) == 1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {         //facing right
                    if (getMazeElement(mob.getY(), mob.getX() + 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() + 1) instanceof Enemy) {
                        mob.bev.setOldX(mob.getX() - 1);
                        mob.bev.setOldY(mob.getY());
                        return false;
                    }
                    else {
                        return true;
                    }

                }
                //!!!!!!!!
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == 1 ) {   //facing upward
                    if (getMazeElement(mob.getY() + 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() + 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY() + 1);
                        mob.bev.setOldX(mob.getX());
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == -1) {   //facing downward
                    if (getMazeElement(mob.getY() - 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() - 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY() - 1);
                        mob.bev.setOldX(mob.getX());
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == -1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {   //facing left
                    if (getMazeElement(mob.getY(), mob.getX() - 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() - 1) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY());
                        mob.bev.setOldX(mob.getX() - 1);
                        return false;
                    }
                    else {
                        //NEEDS MORE CODE HERE ABOUT NEXT COORDS
                        return true;
                    }
                }
                break;
            case 'r':
                if (mob.getHorizontalOffset(mob.bev.getOldX()) == 1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {         //facing right
                    if (getMazeElement(mob.getY(), mob.getX() + 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() + 1) instanceof Enemy) {
                        mob.bev.setOldX(mob.getX());    //Facing downward
                        mob.bev.setOldY(mob.getY() + 1);
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == 1 ) {   //facing upward
                    if (getMazeElement(mob.getY() + 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() + 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY()); //Facing right
                        mob.bev.setOldX(mob.getX() - 1);
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == -1) {   //facing downward
                    if (getMazeElement(mob.getY() - 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() - 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY());    //Facing left
                        mob.bev.setOldX(mob.getX() + 1);
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == -1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {   //facing left
                    if (getMazeElement(mob.getY(), mob.getX() - 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() - 1) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY() - 1);    //Facing upward
                        mob.bev.setOldX(mob.getX());
                        return false;
                    }
                    else {
                        //NEEDS MORE CODE HERE ABOUT NEXT COORDS behaviour.setNewX
                        return true;
                    }
                }
                break;
            case 'b':
                if (mob.getHorizontalOffset(mob.bev.getOldX()) == 1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {         //facing right
                    if (getMazeElement(mob.getY(), mob.getX() + 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() + 1) instanceof Enemy) {
                        mob.bev.setOldX(mob.getX() + 1);    //Facing left
                        mob.bev.setOldY(mob.getY());
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == 1 ) {   //facing upward
                    if (getMazeElement(mob.getY() + 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() + 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY() + 1); //Facing downward
                        mob.bev.setOldX(mob.getX());
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == 0 && mob.getVerticalOffset(mob.bev.getOldY()) == -1) {   //facing downward
                    if (getMazeElement(mob.getY() - 1, mob.getX()) instanceof Wall || getMazeElement(mob.getY() - 1, mob.getX()) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY() - 1);    //Facing upward
                        mob.bev.setOldX(mob.getX());
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else if (mob.getHorizontalOffset(mob.bev.getOldX()) == -1 && mob.getVerticalOffset(mob.bev.getOldY()) == 0) {   //facing left
                    if (getMazeElement(mob.getY(), mob.getX() - 1) instanceof Wall || getMazeElement(mob.getY(), mob.getX() - 1) instanceof Enemy) {
                        mob.bev.setOldY(mob.getY());    //Facing right
                        mob.bev.setOldX(mob.getX() - 1);
                        return false;
                    }
                    else {
                        //NEEDS MORE CODE HERE ABOUT NEXT COORDS behaviour.setNewX
                        return true;
                    }
                }
                break;
            default:
                System.out.println("Something went wrong");
                return false;
                break;
        }
    }

    public void printMaze() {

        System.out.printf("Score: %d\tLives: %d\tPowerTurns: %d\n", this.score, this.lives, this.powerPillTurns);

        for (int i = 0; i < this.columns; i++) {

            for (int j = 0; j < this.rows; j++) {

                System.out.print(this.maze[i][j].toString());

            }

            System.out.println();

        }
	*/
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

}
