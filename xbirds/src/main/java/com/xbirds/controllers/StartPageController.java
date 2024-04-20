package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
        private VBox inputBox;

        @FXML
        private ProgressBar progressBar;

        @FXML
        private Text stepText;

        @FXML
        void submitInfo() {

        }
    
        @FXML
        void powerOff(ActionEvent event) {
                System.out.println("quitted");
                System.exit(0);
        }
}