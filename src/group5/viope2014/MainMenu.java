package group5.viope2014;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Philip on 21/05/2014.
 */
public class MainMenu extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pac-Man");
    Button start = new Button(), create = new Button(), exit = new Button();
        start.setText("Load Maze");
        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
        public void handle(ActionEvent event) {

                final Stage loadMaze = new Stage();
                loadMaze.setTitle("Load Maze");
                loadMaze.initModality(Modality.WINDOW_MODAL);

            /* GridPane submenuLoad = new GridPane();
                submenuLoad.setAlignment(Pos.BASELINE_CENTER);
                submenuLoad.setHgap(10);
                submenuLoad.setVgap(10);
                submenuLoad.setPadding(new Insets(25, 25, 25, 25));

              Scene menuScene = new Scene(submenuLoad, 200, 175);
               loadMaze.setScene(menuScene);
*/
                Label open = new Label("Type path of file to open: ");
                open.setAlignment(Pos.BASELINE_CENTER);
                //submenuLoad.add(open, 0, 0);

                TextField fileName = new TextField();
                final String file = fileName.getText();

               // submenuLoad.add(fileName, 0, 1);

                Button load = new Button();
                load.setText("Start Busting Ghosts!");
             // submenuLoad.add(load, 0, 2 );
                load.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        new Maze("filename.txt");
                    }

                });

             ;

                VBox vBox = new VBox();
                vBox.setSpacing(40);
                vBox.getChildren().addAll(open, fileName, load);

                loadMaze.setScene(new Scene(vBox));
                loadMaze.show();


                  }
        });

        create.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

             // Maze.newMaze();
            }});
   StackPane root = new StackPane();
    root.getChildren().add(start);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();}
}
