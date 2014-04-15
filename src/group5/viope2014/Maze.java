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

     @Override public String toString() {
        String currentConfig = "";
        String currentElement = "W";    //Assuming every maze starts with a wall in the 0,0 position.
        int counter = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentElement == maze[i][j].toString()) {
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

    public void setMaze(String startConfig) {
        int y = 0, x = 0, counter = 1;
        char currentElement = 'W';
        while (y < this.rows) {
            for (int i = 0; i < startConfig.length(); i++) {
                if (Character.toString(startConfig.charAt(i)).compareTo("$") == 0) {
                    y++;                                                            // if "$" then next row.
                    x = 0;                                                          // set X to the start of the row.
                    if (y == this.rows) {                                            // terminate the loop. each startConfig String should end with a "$", thus leading to a y == this.rows
                        break;
                    }
                    continue;
                }
                try {
                    counter = (int) startConfig.charAt(i);                          //this method only supports expressions chars 1-9.
                } catch (NumberFormatException e) {                                 // Catching the exception works as a trigger for the following loop
                    currentElement = startConfig.charAt(i);
                    for (int j = x; j < x+counter;i++) {                            // Might throw IndexOutOfBoundsException
                        switch (currentElement) {                                   // placeholder cases for once the actual MazeElement and Behaviour classes work as intended
                            case 'X' : setMazeElement(y, (x+i), new PacMan());
                                break;
                            case 'r' : setMazeElement(y, (x+i), new Enemy(new BlinkyBehaviour());
                                break;
                            case 'p' : setMazeElement(y, (x+i), new Enemy(new PinkyBehaviour());
                                break;
                            case 'c' : setMazeElement(y, (x+i), new Enemy(new InkyBehaviour());
                                break;
                            case 'o' : setMazeElement(y, (x+i), new Enemy(new ClydeBehaviour());
                                break;
                            case 'P' : setMazeElement(y, (x+i), new Pill());
                                break;
                            case 'd' : setMazeElement(y, (x+i), new Dot());
                                break;
                            case 'W' : setMazeElement(y, (x+i), new Wall());
                                break;
                            case '_' : setMazeElement(y, (x+i), new Empty());
                        }
                    }
                    x+=counter;                                                     //shift x's position.
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
        vars = lastLine.split("|");
        try {
            this.rows = Integer.parseInt(vars[0]);
            this.columns = Integer.parseInt(vars[1]);
            this.powerPillTurns = Integer.parseInt(vars[2]);
            this.score = Integer.parseInt(vars[3]);
            this.lives = Integer.parseInt(vars[4]);
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

    }
}
