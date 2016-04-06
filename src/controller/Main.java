package controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Created by Michal on 01/11/2015.
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/LogIn.fxml"));
        primaryStage.setTitle("P1 project");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);


    }
}
