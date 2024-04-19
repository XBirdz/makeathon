package com.xbirds.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StartPageController { 
        @FXML
        private ImageView powerButton;
    
        @FXML
        void powerOff(MouseEvent event) {
                System.out.println("Power Off presser");
        }
}

