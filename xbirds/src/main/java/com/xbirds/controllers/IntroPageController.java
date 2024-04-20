package com.xbirds.controllers;

import java.io.IOException;

import com.xbirds.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class IntroPageController {

    @FXML
    private ImageView showcaseImage;

    @FXML
    void power(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void openStartPage(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StartPage.fxml")); 
            Parent root;
            try {
                    root = loader.load();
                    Scene startPageScene = new Scene(root, 800, 500);
                    startPageScene.setFill(null);
                    App.window.setScene(startPageScene);
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

}