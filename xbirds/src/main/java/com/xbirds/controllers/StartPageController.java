package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartPageController { 
        @FXML
        private ComboBox<String> activitySelect;

        @FXML
        private TextField endDateText;

        @FXML
        private VBox inputBox;

        @FXML
        private TextField maxPriceText;

        @FXML
        private TextField minPriceText;

        @FXML
        private ComboBox<?> prefWeatherSelect;

        @FXML
        private ProgressBar progressBar;

        @FXML
        private TextField startDateText;

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