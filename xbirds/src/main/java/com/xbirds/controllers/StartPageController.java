package com.xbirds.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        void initialize() {
            activitySelect.setItems(FXCollections.observableArrayList("Sightseeing", "Beach", "Skiing", "Hiking", "Camping", "City Break", "Adventure", "Relaxing", "Cultural", "Shopping", "Food & Drink", "Nightlife", "Sports", "Wellness", "Family", "Romantic", "Solo", "Group", "Business", "Other"));

            prefWeatherSelect.setItems(FXCollections.observableArrayList("Clear sky", "Mainly clear", "Partly cloudy", "Overcast", "Fog", "Depositing rime fog", "Drizzle: Light", "Drizzle: Moderate", "Drizzle: Dense", "Freezing Drizzle: Light", "Freezing Drizzle: Dense", "Rain: Slight", "Rain: Moderate", "Rain: Heavy", "Freezing Rain: Light", "Freezing Rain: Heavy", "Snow fall: Slight", "Snow fall: Moderate", "Snow fall: Heavy", "Snow grains", "Rain showers: Slight", "Rain showers: Moderate", "Rain showers: Violent", "Snow showers: Slight", "Snow showers: Heavy", "Thunderstorm: Slight or moderate", "Thunderstorm with slight hail", "Thunderstorm with heavy hail"));

            minPriceListener();
            maxPriceListener();

            startDateListener();
            endDateListener();
        }

        @FXML
        void startDateListener() {
            startDateText.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) { // Check if the field has lost focus
                    String startDate = startDateText.getText();
                    if (!startDate.isEmpty() && !isValidDate(startDate)) { // Check if string is NOT empty
                        showAlert("Invalid Start Date", "Please enter a valid start date in the format dd/MM/yyyy");
                        startDateText.clear(); // Optionally clear the field
                    } else {
                        // Print the start date since it's valid
                        System.out.println("Valid Start Date: " + startDate);
                    }
                }
            });
        }

        @FXML
        void endDateListener() {
            endDateText.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) { // Check if the field has lost focus
                    String endDate = endDateText.getText(); // Store endDate
                    if (!endDate.isEmpty() && !isValidDate(endDate)) { // Check if string is NOT empty
                        showAlert("Invalid End Date", "Please enter a valid end date in the format dd/MM/yyyy");
                        endDateText.clear(); // Optionally clear the field
                    } else {
                        // Print the end date since it's valid
                        System.out.println("Valid End Date: " + endDate);
                    }
                }
            });
        }
    
        private boolean isValidDate(String dateString) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate.parse(dateString, formatter);
                // check if the date is in the future
                if (LocalDate.parse(dateString, formatter).isBefore(LocalDate.now())) {
                    return false;
                }
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }

        @FXML
        private TextField minPriceText;

        @FXML
        private ComboBox<String> prefWeatherSelect = new ComboBox<String>();


        @FXML
        private ProgressBar progressBar;

        @FXML
        private TextField startDateText;

        @FXML
        private Text stepText;

        @FXML
        void submitInfo() {
            minPriceListener();
            maxPriceListener();

        }

        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);  // Optional: Remove header
            alert.setContentText(message);
            alert.showAndWait();
        }

        // Create me a listener for the minPriceText field to get the value of the text field

        @FXML
        void minPriceListener() {
            minPriceText.textProperty().addListener(new ChangeListener<>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // This method will be called whenever the text changes

                    // Do something with the new value
                    System.out.println("New minimum price: " + newValue);

                    // Example: Basic validation (only allow numbers)
                    if (!newValue.matches("\\d*\\.?\\d*")) {
                        minPriceText.setText(oldValue); // Revert to the old value
                    }
                }
            });
        }

        @FXML
        void maxPriceListener() {
            maxPriceText.textProperty().addListener(new ChangeListener<>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    System.out.println("New maximum price: " + newValue); 

                    // Example: Basic validation (only allow numbers)
                    if (!newValue.matches("\\d*\\.?\\d*")) {
                        maxPriceText.setText(oldValue);
                    }
                }
            });
        }

    
        @FXML
        void powerOff(ActionEvent event) {
                System.out.println("quitted");
                System.exit(0);
        }
}