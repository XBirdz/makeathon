package com.xbirds.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StartPageController { 
        @FXML
        private TextField activityTextField;

        @FXML
        private TextField dateTextField;

        @FXML
        private TextField vacationDaysTextField;

        @FXML
        private TextField weatherTextField;
    
        @FXML
        void powerOff(MouseEvent event) {
                System.out.println("Power Off presser");
                System.exit(0);
        }
}

