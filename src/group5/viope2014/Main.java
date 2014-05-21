package group5.viope2014;

import com.sun.javafx.scene.traversal.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

public class Main extends Application {


    public GUI controller;
    private Maze field;
    private int dir=0;
    private Behaviour bev;
    private boolean endGame=false;
	Timeline timeline;
    /// Used for GUI, please don't modify!
    @Override
    public void start(final Stage primaryStage) throws Exception {

        field = new Maze("filename.txt");
        field.reload();
        bev =field.getPMBev();
        controller = new GUI();
        controller.regMaze(this.field);
        field.regController(controller);
        //field.reload();
        controller.buildGrid();
        controller.readMaze();
        Music.PlaySound();
        loadMap();      //Load buttonlistener
        primaryStage.setTitle("Pacman-simulator by Ghostbusters");
        primaryStage.setMinWidth(9 * 39);
        Scene s=new Scene(controller, field.getColumns() * 39, field.getRows() * 40 + 18);
        s.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                KeyCode kc=event.getCode();
                if(kc==KeyCode.UP)
                    dir=choseDirection.Move_Up;
                else if(kc== KeyCode.DOWN)
                    dir=choseDirection.Move_Down;
                else if(kc==KeyCode.LEFT)
                    dir=choseDirection.Move_Left;
                else if(kc==KeyCode.RIGHT)
                    dir=choseDirection.Move_Right;
                bev.setDirection(dir);
            }
        });
        primaryStage.setScene(s);
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        startGame();
        //controller.gameOver();
            /*Scanner sc = new Scanner(System.in);
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
							Music.stopSound();
                            System.exit(0);
                            break;
                    }
                }
                catch(EndGameException e)
                {
					Music.stopSound();
                    System.out.println("Game ended!");
                }
                //ADD cls here
            }*/

    }

    public void setEndGame(boolean b) {
        this.endGame = b;
    }

    public void graphicsLoop() {
        timeline = new Timeline(new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.cls();
                controller.readMaze();
                if (endGame) {
                    controller.gameOver();
                    timeline.stop();

                }

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void gameLoop() {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    field.move();
                } catch (EndGameException e) {
                    System.out.println("Game Over"); // Replace with game over -screen
                    setEndGame(true);
                    cancel();
                    return;

                }

            }
        }, 750, 750);

    }

    public static void main(String[] args) {

        launch(args);

    }

    public void startGame()
    {
        gameLoop();         //loop 1
        graphicsLoop();     // loop 2
    }
   public void loadMap() {
       controller.load.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               field = new Maze(controller.map.getText());
               //field.setFilename(controller.map.getText());
               field.reload();
               //controller.borderPane.setPrefWidth(field.getColumns() * 39);
               //controller.borderPane.setPrefHeight(field.getRows() * 40 + 14);
               //controller.borderPane.setPrefHeight(field.getRows() * 40 + 14);
               //controller.borderPane.setPrefWidth(900);
               controller.regMaze(field);
               controller.readMaze();
               setEndGame(false);
               bev =field.getPMBev();
               startGame();
               System.out.print("Pylly");
           }
       });
       ;
   }

}