package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
        void powerOff(ActionEvent event) {
                System.out.println("quitted");
                System.exit(0);
        }
}