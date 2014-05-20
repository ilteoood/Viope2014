package group5.viope2014;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class GUI extends BorderPane {

    int width;
    int height;


    FXMLLoader loader;
    Maze maze;
    @FXML
    BorderPane borderPane;

    @FXML
    GridPane gameField;

    @FXML
    HBox top;

    @FXML
    VBox right, left;


    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.UP) {
                try {
                    //your code for moving Pacman
                } catch (Exception e) {
                    e.printStackTrace();
                }
                event.consume();
            }
            else if(event.getCode() == KeyCode.DOWN) {
                try {
                    //your code for moving Pacman
                } catch (Exception e) {
                    e.printStackTrace();
                }
                event.consume();
            }
            else if(event.getCode() == KeyCode.RIGHT) {
                try {
                    //your code for moving Pacman
                } catch (Exception e) {
                    e.printStackTrace();
                }
                event.consume();
            }
            else if(event.getCode() == KeyCode.LEFT) {
                try {
                    //your code for moving Pacman
                } catch (Exception e) {
                    e.printStackTrace();
                }
                event.consume();
            }
        }
    };

    public void regMaze(Maze x) {
        this.maze = x;
        this.width = maze.getColumns();
        this.height = maze.getRows();
    }


    public GUI() {
        loader = new FXMLLoader(getClass().getResource("GUI_fxml.fxml"));
        loader.setController(this);
        loader.setRoot(this);


        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Global variables


    public void initialize() {

        gameField = new GridPane();
        top = new HBox();
        top.setStyle("-fx-background-color: black;");
        top.setAlignment(Pos.CENTER_LEFT);
        gameField.setAlignment(Pos.TOP_LEFT);
        borderPane.setCenter(gameField);
        borderPane.setTop(top);
        borderPane.setStyle("-fx-background-color: black;");

        //playField.setFont(Font.font("Courier New", FontWeight.BOLD, 18)); /// Set font of text-area
        //playField.setVisible(false);

        /* Clear playfield button functionality added here
        clearField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playField.clear();
            }
        });
        ;
        */


    }

    public void readMaze()

    {
        String currentElement = null;
        for (int column = 0; column < width; column++) {
            for (int row = 0; row < height; row++) {
                //System.out.printf("X: %d, Y: %d\n", column, row);
                currentElement = maze.getMazeElement(row, column).toString();
                switch (currentElement.charAt(0)) {
                    case 'X':
                        //GridPane.setConstraints(PacMan.getPicture(), row, column);
                        //gameField.getChildren().add(PacMan.getPicture());
                        gameField.add(PacMan.getPicture(), column, row);
                        break;
                    case 'r':
                        gameField.add(Blinky.getPicture(), column, row);
                        break;
                    case 'p':
                        gameField.add(Pinky.getPicture(), column, row);
                        break;
                    case 'c':
                        gameField.add(Inky.getPicture(), column, row);
                        break;
                    case 'o':
                        gameField.add(Clyde.getPicture(), column, row);
                        break;

                    case 'P':
                        gameField.add(Pill.getPicture(), column, row);
                        break;
                    case 'd':
                        gameField.add(Dot.getPicture(), column, row);
                        break;
                    case 'W':
                        gameField.add(Wall.getPicture(),column, row);
                        break;
                    case '_':
                        gameField.add(new Rectangle(40.0,40.0,Color.WHITE), column, row);
                        break;
                    default:
                        break;
                }

            }
        }

        Label score = new Label("Score: " + String.valueOf(maze.getScore()));
        score.setPadding(new Insets(0, 20, 0, 0));
        score.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 20));
        score.setTextFill(Color.WHITE);

        Label powerPills = new Label("PP: " + String.valueOf(maze.getPowerPillTurns()));
        powerPills.setPadding(new Insets(0, 20, 0, 20));
        powerPills.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 20));
        powerPills.setTextFill(Color.WHITE);

        Label lives = new Label("Lives: " + String.valueOf(maze.getLives()));
        lives.setPadding(new Insets(0, 20, 0, 20));
        lives.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 20));
        lives.setTextFill(Color.WHITE);

        top.getChildren().addAll(score, powerPills, lives);

        top.setFillHeight(true);
        top.setStyle("-fx-background-color: black;");
    }


    public void buildGrid() {

        gameField.setGridLinesVisible(true);
        //gameField.setHgap(10);
        //gameField.setVgap(10);
        //gameField.setPadding(new Insets(0, 10, 0, 10));

        for (int i = 0; i < this.width; i++) {
            gameField.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for (int i = 0; i < this.height; i++) {
            gameField.getRowConstraints().add(new RowConstraints((40)));
        }



    }

    public void cls() {
        gameField.getChildren().clear();
        top.getChildren().clear();
    }

}