package group5.viope2014;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.audio.AudioPlayer;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {


    public GUI controller;
    private Maze field;


    /// Used for GUI, please don't modify!
    @Override
    public void start(Stage primaryStage) throws Exception {
        field = new Maze("filename.txt");
        field.reload();
        controller = new GUI();
        controller.regMaze(this.field);
        field.regController(controller);
        //field.reload();
        controller.buildGrid();
        controller.readMaze();
        primaryStage.setTitle("Pacman-simulator by Ghostbusters");
        primaryStage.setMinWidth(9 * 39);
        primaryStage.setScene(new Scene(controller, field.getColumns() * 39, field.getRows() * 40 + 18));
        primaryStage.setResizable(false);
        primaryStage.show();
        gameLoop();         //loop 1
        graphicsLoop();     // loop 2

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
                            System.exit(0);
                            break;
                    }
                }
                catch(EndGameException e)
                {
                    System.out.println("Game ended!");
                }
                //ADD cls here
            }*/

    }

    public void graphicsLoop(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.cls();
                controller.readMaze();
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
                    System.out.println("Game Over");
                    AudioPlayer.player.stop();
                }

            }
        }, 1000, 1000);

    }

    public static void main(String[] args) {
        launch(args);

    }
}