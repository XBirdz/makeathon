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
    private TextField minPriceText;

    @FXML
    private ComboBox<String> prefWeatherSelect;

    @FXML
    private ComboBox<String> accomodationSelect;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TextField startDateText;

    @FXML
    private Text stepText;

        

        @FXML
        void initialize() {
            activitySelect.setItems(FXCollections.observableArrayList("Sightseeing", "Beach", "Skiing", "Hiking", "Camping", "City Break", "Adventure", "Relaxing", "Cultural", "Shopping", "Food & Drink", "Nightlife", "Sports", "Wellness", "Family", "Romantic", "Solo", "Group", "Business", "Other"));
            prefWeatherSelect.setItems(FXCollections.observableArrayList("Clear sky", "Mainly clear", "Partly cloudy", "Overcast", "Fog", "Depositing rime fog", "Drizzle: Light", "Drizzle: Moderate", "Drizzle: Dense", "Freezing Drizzle: Light", "Freezing Drizzle: Dense", "Rain: Slight", "Rain: Moderate", "Rain: Heavy", "Freezing Rain: Light", "Freezing Rain: Heavy", "Snow fall: Slight", "Snow fall: Moderate", "Snow fall: Heavy", "Snow grains", "Rain showers: Slight", "Rain showers: Moderate", "Rain showers: Violent", "Snow showers: Slight", "Snow showers: Heavy", "Thunderstorm: Slight or moderate", "Thunderstorm with slight hail", "Thunderstorm with heavy hail"));
            accomodationSelect.setItems(FXCollections.observableArrayList("Pool", "Spa", "Beachfront", "Dog Friendly", "Adult Only", "Honeymoon", "Skyscraper", "Infinity Pool", "Luxury", "Historic", "Parking", "Boutique-Style", "Family", "Yoga", "Ski In Ski Out", "Unusual", "Castle", "Cheap", "Overwater Bungalows", "Ski", "Vineyard", "Monastery", "Small", "Romantic", "Nightlife", "5 Star", "4 Star", "3 Star", "Haunted", "Pool Lap Lanes", "Pool Swim Up Bar", "Pool Water Slide", "Panoramic View Pool", "Rooftop Pool", "Water Park", "Wave Pool", "Lazy River", "Private Pool", "Heated Pool", "Indoor Pool", "Outdoor Pool", "Children's Pool", "Dogs Stay Free", "Dog Play Area", "Dog Sitting", "Rooms with Fireplace", "All-Inclusive Packages", "Rooms with Jacuzzi / Hot-Tub", "Health & Safety", "EV charging stations", "Gym", "Free Wi-Fi", "Business", "Treehouse", "Tennis", "Beach", "Accessible", "Casino", "Sustainability Journey", "Golf"));
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
        void submitInfo() {
            
            if(!endDateText.getText().isEmpty() || !isValidDate(endDateText.getText())) {
                System.out.println("error in end date");
                return;
            }

            if(!endDateText.getText().isEmpty() || !isValidDate(endDateText.getText())) {
                System.out.println("error in end date");
                return;
            }

            if (minPriceText.getText().matches("\\d*\\.?\\d*") || Integer.parseInt(minPriceText.getText()) >= 0) {
                System.out.println("error in min price");
                return;
            }

            if (maxPriceText.getText().matches("\\d*\\.?\\d*") || Integer.parseInt(maxPriceText.getText()) >= 0) {
                System.out.println("error in max price");
                return;
            }

            System.out.println("successful validation");

        }

        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);  // Optional: Remove header
            alert.setContentText(message);
            alert.showAndWait();
        }
    
        @FXML
        void powerOff(ActionEvent event) {
                System.out.println("quitted");
                System.exit(0);
        }
}