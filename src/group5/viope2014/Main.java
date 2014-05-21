package group5.viope2014;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {


    public GUI controller;
    private Maze field;
    private int dir = 0;
    private Behaviour bev;
    private boolean endGame = false;
    Timeline timeline;

    /// Used for GUI, please don't modify!
    @Override
    public void start(final Stage primaryStage) throws Exception {

        field = new Maze("filename.txt");
        field.reload();
        bev = field.getPMBev();
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
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        Scene s = new Scene(controller, field.getColumns() * 39, field.getRows() * 40 + 18);
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode kc = event.getCode();
                if (kc == KeyCode.UP)
                    dir = choseDirection.Move_Up;
                else if (kc == KeyCode.DOWN)
                    dir = choseDirection.Move_Down;
                else if (kc == KeyCode.LEFT)
                    dir = choseDirection.Move_Left;
                else if (kc == KeyCode.RIGHT)
                    dir = choseDirection.Move_Right;
                bev.setDirection(dir);
            }
        });
        primaryStage.setScene(s);
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        startGame();

    }

    public void setEndGame(boolean b) {
        this.endGame = b;
    }

    public void graphicsLoop() {
        timeline = new Timeline(new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {
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
        }, 700, 700);

    }

    public static void main(String[] args) {

        launch(args);

    }

    public void startGame() {
        gameLoop();         //loop 1
        graphicsLoop();     // loop 2
    }

    public void loadMap() {
        controller.load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field = new Maze(controller.map.getText());
                field.reload();
                controller.regMaze(field);
                controller.readMaze();
                setEndGame(false);
                bev = field.getPMBev();
                startGame();

            }
        });
        ;
    }

}