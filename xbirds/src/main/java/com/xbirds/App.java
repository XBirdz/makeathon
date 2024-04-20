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
    public static Stage window;
    public static void main( String[] args )
    {
        Tasos_tests.test();
        launch(args);
        
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/IntroPage.fxml"));
        Parent root = loader.load();
        window = primaryStage;
        window.setTitle("SunSeeker");
      
         Scene scene = new Scene(root, 800, 500);
         scene.setFill(null);
       
         window.setResizable(false);
         window.initStyle(StageStyle.TRANSPARENT);
 
         window.setScene(scene);
         window.show();
      }
      

}
