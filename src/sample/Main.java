package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Окно чата");
        Scene scene = new Scene(root, 500, 275, Color.BLUE);
        scene.setFill(Color.BROWN);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();
       // primaryStage.setOpacity(500);
    }


    public static void main(String[] args) {
        launch(args);


    }
}
