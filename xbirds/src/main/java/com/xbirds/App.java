package com.xbirds;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
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
      
        // Get screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
      
        // Set scene width and height relative to screen size
        Scene scene = new Scene(root, screenWidth * 0.8, screenHeight * 0.8);
        scene.setFill(null);
      
        // Allow resizing based on user preference
        window.setResizable(true);
      
        // Optional: Set minimum and maximum sizes to prevent excessive resizing
        window.setMinHeight(400);
        window.setMinWidth(600);
        window.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene);
        window.show();
      }
      

}
