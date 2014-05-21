package group5.viope2014;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class GUI extends BorderPane {
    // Global variables
    int width;
    int height;
    FXMLLoader loader;
    Maze maze;
    @FXML
    BorderPane borderPane;
    @FXML
    GridPane gameField;
    @FXML
    HBox top, buttons;
    @FXML
    VBox gameOver;
    @FXML
    Button load;
    @FXML
    TextField map;


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

    public void initialize() {
        //Creation
        load = new Button();
        map = new TextField();
        gameField = new GridPane();
        buttons = new HBox();
        top = new HBox();

        // Styling
        buttons.getChildren().addAll(map, load);
        buttons.setAlignment(Pos.CENTER);
        load.setVisible(false);
        map.setVisible(false);

        top.setStyle("-fx-background-color: black;");
        borderPane.setStyle("-fx-background-color: black;");
        //borderPane.setPrefHeight(365);
        //borderPane.setPrefWidth(600);
        buttons.setSpacing(15.0);
        // map.setPadding(new Insets(0,0,0,0));
        //  load.setPadding(new Insets(0,0,0,10));
        load.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 12));
        load.setTextFill(Color.BLACK);
        load.setText("Load map");


        //Position
        top.setAlignment(Pos.CENTER);
        gameField.setAlignment(Pos.CENTER);
        borderPane.setTop(top);

    }

    public void readMaze() {

        borderPane.setCenter(gameField);
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
                        gameField.add(Wall.getPicture(), column, row);
                        break;
                    case '_':
                        gameField.add(Empty.getPicture(), column, row);
                        //gameField.add(new Rectangle(40.0, 40.0, Color.WHITE), column, row);
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

    public void gameOver() {
        load.setVisible(true);
        map.setVisible(true);
        borderPane.getChildren().remove(gameField);
        //borderPane.getChildren().remove(top);
        gameOver = new VBox();
        Label labelGO = new Label("GAME OVER");
        map.setText(maze.getFilename());
        //derp.setPadding(new Insets(0, 20, 0, 20));
        labelGO.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 50));
        labelGO.setTextFill(Color.WHITE);
        borderPane.setCenter(gameOver); // Game over img - element here
        gameOver.getChildren().addAll(labelGO, buttons);
        gameOver.setAlignment(Pos.CENTER);

    }


}
