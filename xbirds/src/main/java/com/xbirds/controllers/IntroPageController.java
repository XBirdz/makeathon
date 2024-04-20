package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class IntroPageController {

    @FXML
    private ImageView showcaseImage;

    @FXML
    void power(ActionEvent event) {
        System.exit(0);
    }

}