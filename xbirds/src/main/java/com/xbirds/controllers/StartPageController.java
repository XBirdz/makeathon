package com.xbirds.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import com.xbirds.FrontLayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartPageController { 

    @FXML
    private TilePane inputBox;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Text stepText;

    @FXML
    private Text questionText;


    private String[] activities = {"Sightseeing", "Beach", "Skiing", "Hiking", "Camping", "City Break", "Adventure", "Relaxing", "Cultural", "Shopping", "Food & Drink", "Nightlife", "Sports", "Wellness", "Family", "Romantic", "Solo", "Group", "Business"};
    private String[] prefWeatherOptions = {"Clear sky", "Mainly clear", "Partly cloudy", "Overcast", "Fog", "Depositing rime fog", "Drizzle: Light", "Drizzle: Moderate", "Drizzle: Dense", "Freezing Drizzle: Light", "Freezing Drizzle: Dense", "Rain: Slight", "Rain: Moderate", "Rain: Heavy", "Freezing Rain: Light", "Freezing Rain: Heavy", "Snow fall: Slight", "Snow fall: Moderate", "Snow fall: Heavy", "Snow grains", "Rain showers: Slight", "Rain showers: Moderate", "Rain showers: Violent", "Snow showers: Slight", "Snow showers: Heavy", "Thunderstorm: Slight or moderate", "Thunderstorm with slight hail", "Thunderstorm with heavy hail"};
    private String[] accomodationOptions = {"Pool", "Spa", "Beachfront", "Dog Friendly", "Adult Only", "Honeymoon", "Skyscraper", "Infinity Pool", "Luxury", "Historic", "Parking", "Boutique-Style", "Family", "Yoga", "Ski In Ski Out", "Unusual", "Castle", "Cheap", "Overwater Bungalows", "Ski", "Vineyard", "Monastery", "Small", "Romantic", "Nightlife", "5 Star", "4 Star", "3 Star", "Haunted", "Pool Lap Lanes", "Pool Swim Up Bar", "Pool Water Slide", "Panoramic View Pool", "Rooftop Pool", "Water Park", "Wave Pool", "Lazy River", "Private Pool", "Heated Pool", "Indoor Pool", "Outdoor Pool", "Children's Pool", "Dogs Stay Free", "Dog Play Area", "Dog Sitting", "Rooms with Fireplace", "All-Inclusive Packages", "Rooms with Jacuzzi / Hot-Tub", "Health & Safety", "EV charging stations", "Gym", "Free Wi-Fi", "Business", "Treehouse", "Tennis", "Beach", "Accessible", "Casino", "Sustainability Journey", "Golf"};    

    private ArrayList<String> selectedActivities;
    private ArrayList<String> selectWeatherPref;
    private ArrayList<String> selectedAccomodationOptions;
    private ArrayList<String> selectedDistances;
    String location;
    String[] startDate;
    String[] endDate;
    String budget;
    String company;

    TextField locationField;
    TextField startDateField;
    TextField endDateField;
    TextField budgetField;
    TextField companyField;

    int step = 1;

        @FXML
        void initialize() {
            //activitySelect.setItems(FXCollections.observableArrayList("Sightseeing", "Beach", "Skiing", "Hiking", "Camping", "City Break", "Adventure", "Relaxing", "Cultural", "Shopping", "Food & Drink", "Nightlife", "Sports", "Wellness", "Family", "Romantic", "Solo", "Group", "Business", "Other"));
            //prefWeatherSelect.setItems(FXCollections.observableArrayList("Clear sky", "Mainly clear", "Partly cloudy", "Overcast", "Fog", "Depositing rime fog", "Drizzle: Light", "Drizzle: Moderate", "Drizzle: Dense", "Freezing Drizzle: Light", "Freezing Drizzle: Dense", "Rain: Slight", "Rain: Moderate", "Rain: Heavy", "Freezing Rain: Light", "Freezing Rain: Heavy", "Snow fall: Slight", "Snow fall: Moderate", "Snow fall: Heavy", "Snow grains", "Rain showers: Slight", "Rain showers: Moderate", "Rain showers: Violent", "Snow showers: Slight", "Snow showers: Heavy", "Thunderstorm: Slight or moderate", "Thunderstorm with slight hail", "Thunderstorm with heavy hail"));
            //accomodationSelect.setItems(FXCollections.observableArrayList("Pool", "Spa", "Beachfront", "Dog Friendly", "Adult Only", "Honeymoon", "Skyscraper", "Infinity Pool", "Luxury", "Historic", "Parking", "Boutique-Style", "Family", "Yoga", "Ski In Ski Out", "Unusual", "Castle", "Cheap", "Overwater Bungalows", "Ski", "Vineyard", "Monastery", "Small", "Romantic", "Nightlife", "5 Star", "4 Star", "3 Star", "Haunted", "Pool Lap Lanes", "Pool Swim Up Bar", "Pool Water Slide", "Panoramic View Pool", "Rooftop Pool", "Water Park", "Wave Pool", "Lazy River", "Private Pool", "Heated Pool", "Indoor Pool", "Outdoor Pool", "Children's Pool", "Dogs Stay Free", "Dog Play Area", "Dog Sitting", "Rooms with Fireplace", "All-Inclusive Packages", "Rooms with Jacuzzi / Hot-Tub", "Health & Safety", "EV charging stations", "Gym", "Free Wi-Fi", "Business", "Treehouse", "Tennis", "Beach", "Accessible", "Casino", "Sustainability Journey", "Golf"));

            selectedActivities = new ArrayList<String>();
            selectWeatherPref = new ArrayList<String>();
            selectedAccomodationOptions = new ArrayList<String>();

            for(int i = 0; i < activities.length; i++) {
                Button b = new Button(activities[i]);
                b.setStyle("-fx-border-radius: 20; -fx-background-radius: 20; -fx-background-color: white;" +
                        "-fx-border-width: 1; -fx-border-color: #444; -fx-font-size: 10; -fx-text-fill: #000;");
                b.setPadding(new Insets(8, 15, 8, 15));
                b.setOnAction((ActionEvent e) -> {
                    if(b.getStyle().contains("-fx-background-color: white")) {
                        b.setStyle(b.getStyle().replace("white", "#ea006d")
                            .replace("-fx-border-width: 1; -fx-border-color: #444;", "")
                            .replace("-fx-text-fill: #000", "-fx-text-fill: #fff"));
                        selectedActivities.add(b.getText());
                    }
                    else {
                        b.setStyle(b.getStyle().replace("#ea006d", "white")
                            .concat("-fx-border-width: 1; -fx-border-color: #444;")
                            .replace("-fx-text-fill: #fff", "-fx-text-fill: #000"));
                        selectedActivities.remove(b.getText());
                    }
                });
                inputBox.getChildren().add(b);
            }
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
            if(step == 1 && selectedActivities.isEmpty()) {
                System.out.println("Please, select at least one option.");
                return;
            } else if(step == 2 && selectWeatherPref.isEmpty()) {
                System.out.println("Please, select at least one option.");
                return;
            } else if(step == 3 && selectedAccomodationOptions.isEmpty()) {
                System.out.println("Please, select at least one option.");
                return;
            }
            else if (step <= 3) {
                nextPage();
            } else {
                location = locationField.getText();
                startDate = startDateField.getText().split("/");
                endDate = endDateField.getText().split("/");

                String activityString = "";
                for(int i = 0; i < selectedActivities.size(); i++) {
                    activityString += selectedActivities.get(i);
                    if(i < selectedActivities.size() - 1) activityString += ", ";
                }

                String weatherString = "";
                for(int i = 0; i < selectWeatherPref.size(); i++) {
                    weatherString += selectWeatherPref.get(i);
                    if(i < selectWeatherPref.size() - 1) weatherString += ", ";
                }

                String distancesString = "";
                for(int i = 0; i < selectedDistances.size(); i++) {
                    distancesString += selectedDistances.get(i);
                    if(i < selectedDistances.size() - 1) distancesString += ", ";
                }

                String season = "";
                if(startDate[1].equals("01") || startDate[1].equals("02") || startDate[1].equals("12")) {
                    season = "winter";
                } else if(startDate[1].equals("03") || startDate[1].equals("04") || startDate[1].equals("05")) {
                    season = "spring";
                } else if(startDate[1].equals("06") || startDate[1].equals("07") || startDate[1].equals("08")) {
                    season = "summer";
                } else if(startDate[1].equals("09") || startDate[1].equals("10") || startDate[1].equals("11")) {
                    season = "fall";
                }
                
                FrontLayer.giveUserData(selectedAccomodationOptions, activityString, weatherString, distancesString, location, budget, company, season, startDate[0], startDate[1], startDate[2], endDate[0], endDate[1], endDate[2]);
            }
        }

        private void nextPage() {
            step++;
            stepText.setText("Step " + step);
            progressBar.setProgress(0.25 * step);
            inputBox.getChildren().clear();
            
            if(step == 2) {
                questionText.setText("What are your weather preferrences?");
        
                for(int i = 0; i < prefWeatherOptions.length; i++) {
                    Button b = new Button(prefWeatherOptions[i]);
                    b.setStyle("-fx-border-radius: 20; -fx-background-radius: 20; -fx-background-color: white;" +
                            "-fx-border-width: 1; -fx-border-color: #444; -fx-font-size: 10; -fx-text-fill: #000;");
                    b.setPadding(new Insets(5, 10, 5, 10));
                    b.setOnAction((ActionEvent e) -> {
                        if(b.getStyle().contains("-fx-background-color: white")) {
                            b.setStyle(b.getStyle().replace("white", "#ea006d")
                                .replace("-fx-border-width: 1; -fx-border-color: #444;", "")
                                .replace("-fx-text-fill: #000", "-fx-text-fill: #fff"));
                            selectWeatherPref.add(b.getText());
                        }
                        else {
                            b.setStyle(b.getStyle().replace("#ea006d", "white")
                                .concat("-fx-border-width: 1; -fx-border-color: #444;")
                                .replace("-fx-text-fill: #fff", "-fx-text-fill: #000"));
                            selectWeatherPref.remove(b.getText());
                        }
                    });
                    inputBox.getChildren().add(b);
                }
            } else if (step == 3) {
                questionText.setText("What are your accomodation preferrences?");
        
                for(int i = 0; i < accomodationOptions.length; i++) {
                    Button b = new Button(accomodationOptions[i]);
                    b.setStyle("-fx-border-radius: 20; -fx-background-radius: 20; -fx-background-color: white;" +
                            "-fx-border-width: 1; -fx-border-color: #444; -fx-font-size: 8; -fx-text-fill: #000;");
                    b.setPadding(new Insets(5, 10, 5, 10));
                    b.setOnAction((ActionEvent e) -> {
                        if(b.getStyle().contains("-fx-background-color: white")) {
                            b.setStyle(b.getStyle().replace("white", "#ea006d")
                                .replace("-fx-border-width: 1; -fx-border-color: #444;", "")
                                .replace("-fx-text-fill: #000", "-fx-text-fill: #fff"));
                            selectedAccomodationOptions.add(b.getText());
                        }
                        else {
                            b.setStyle(b.getStyle().replace("#ea006d", "white")
                                .concat("-fx-border-width: 1; -fx-border-color: #444;")
                                .replace("-fx-text-fill: #fff", "-fx-text-fill: #000"));
                            selectedAccomodationOptions.remove(b.getText());
                        }
                    });
                    inputBox.getChildren().add(b);
                }
            } else if (step == 4) {
                questionText.setText("Some more information and your are ready!");

                locationField = new TextField();
                locationField.setMaxHeight(40);
                locationField.setMinHeight(40);
                locationField.setMaxWidth(600);
                locationField.setMinWidth(600);
                locationField.setPromptText("Location");
                locationField.setStyle("-fx-background-color: white; -fx-border-color: #999; -fx-border-radius: 10; -fx-background-radius: 10;");

                startDateField = new TextField();
                startDateField.setMaxHeight(40);
                startDateField.setMinHeight(40);
                startDateField.setMaxWidth(600);
                startDateField.setMinWidth(600);
                startDateField.setPromptText("Start Date (dd/mm/yyyy)");
                startDateField.setStyle("-fx-background-color: white; -fx-border-color: #999; -fx-border-radius: 10; -fx-background-radius: 10;");

                endDateField = new TextField();
                endDateField.setMaxHeight(40);
                endDateField.setMinHeight(40);
                endDateField.setMaxWidth(600);
                endDateField.setMinWidth(600);
                endDateField.setPromptText("End Date (dd/mm/yyyy)");
                endDateField.setStyle("-fx-background-color: white; -fx-border-color: #999; -fx-border-radius: 10; -fx-background-radius: 10;");


                Text text = new Text("How far away are you willing to go?");
                
                HBox hbox = new HBox();

                String[] distanceOptions = {"Nearby", "Inside the country", "Outside the country", "Overseas"};
                selectedDistances = new ArrayList<>();
                for(int i = 0; i < distanceOptions.length; i++) {
                    Button b = new Button(distanceOptions[i]);
                    b.setStyle("-fx-border-radius: 20; -fx-background-radius: 20; -fx-background-color: white;" +
                            "-fx-border-width: 1; -fx-border-color: #444; -fx-font-size: 10; -fx-text-fill: #000;");
                    b.setPadding(new Insets(5, 10, 5, 10));
                    b.setOnAction((ActionEvent e) -> {
                        if(b.getStyle().contains("-fx-background-color: white")) {
                            b.setStyle(b.getStyle().replace("white", "#ea006d")
                                .replace("-fx-border-width: 1; -fx-border-color: #444;", "")
                                .replace("-fx-text-fill: #000", "-fx-text-fill: #fff"));
                            selectedDistances.add(b.getText());
                        }
                        else {
                            b.setStyle(b.getStyle().replace("#ea006d", "white")
                                .concat("-fx-border-width: 1; -fx-border-color: #444;")
                                .replace("-fx-text-fill: #fff", "-fx-text-fill: #000"));
                            selectedDistances.remove(b.getText());
                        }
                    });
                    hbox.getChildren().add(b);
                }
                hbox.setSpacing(10);
                VBox distanceBox = new VBox(text, hbox);
                distanceBox.setSpacing(15);

                budgetField = new TextField();
                budgetField.setMaxHeight(40);
                budgetField.setMinHeight(40);
                budgetField.setMaxWidth(280);
                budgetField.setMinWidth(280);
                budgetField.setPromptText("Max Budget");
                budgetField.setStyle("-fx-background-color: white; -fx-border-color: #999; -fx-border-radius: 10; -fx-background-radius: 10;");

                companyField = new TextField();
                companyField.setMaxHeight(40);
                companyField.setMinHeight(40);
                companyField.setMaxWidth(280);
                companyField.setMinWidth(280);
                companyField.setPromptText("Company");
                companyField.setStyle("-fx-background-color: white; -fx-border-color: #999; -fx-border-radius: 10; -fx-background-radius: 10;");
                HBox lastBox = new HBox(budgetField, companyField);
                lastBox.setSpacing(40);


                VBox box = new VBox(locationField, startDateField, endDateField, distanceBox, lastBox);
                box.setSpacing(20);
                inputBox.getChildren().add(box);  
                
            }
        }
    
        @FXML
        void powerOff(ActionEvent event) {
                System.out.println("quitted");
                System.exit(0);
        }
}