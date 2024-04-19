package com.xbirds;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application
{
    Stage window;
    public static void main( String[] args )
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartPage.fxml"));
        window = primaryStage;
        window.setTitle("SunSeeker");
        //Window has fixed dimensions.
        Scene scene = new Scene(root, 1300, 700);
        scene.setFill(null);
        window.setResizable(false); //Do not allow the user to resize the window
        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.show();
    }

}
