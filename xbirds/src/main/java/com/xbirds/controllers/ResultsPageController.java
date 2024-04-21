package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ResultsPageController {

    @FXML
    private Button buttonSuggestion1;

    @FXML
    private Button buttonSuggestion2;

    @FXML
    private Button buttonSuggestion3;

    @FXML
    private Text temperatureSuggestion1;

    @FXML
    private Text temperatureSuggestion2;

    @FXML
    private Text temperatureSuggestion3;

    @FXML
    private Text description1;

    @FXML
    private Text description2;

    @FXML
    private Text description3;

    @FXML
    private Text destination1;

    @FXML
    private Text destination2;

    @FXML
    private Text destination3;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    public static List<String> urls = new ArrayList<>();
    public static List<String> names = new ArrayList<>();
    public static List<String> maxtemp = new ArrayList<>();
    public static List<String> mintemp = new ArrayList<>();

  @FXML
  void initialize(){
    destination3.setText(names.get(2));
    destination1.setText(names.get(0));
    destination2.setText(names.get(1));
    temperatureSuggestion1.setText(String.format("%.1f°C-%.1f°C", Double.parseDouble(mintemp.get(0)), Double.parseDouble(maxtemp.get(0))));
    temperatureSuggestion2.setText(String.format("%.1f°C-%.1f°C", Double.parseDouble(mintemp.get(1)), Double.parseDouble(maxtemp.get(1))));
    temperatureSuggestion3.setText(String.format("%.1f°C-%.1f°C", Double.parseDouble(mintemp.get(2)), Double.parseDouble(maxtemp.get(2))));
  }


    @FXML
    void openSuggestion1(ActionEvent event) {
     
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                try {
                  Desktop.getDesktop().browse(new URI(urls.get(0)));
                } catch (Exception e) {
                  e.printStackTrace();
                  // Handle potential exceptions (e.g., invalid URL)
                  System.out.println("Failed to open browser!");
                }
              } else {
                // Desktop API not supported, display a message
                System.out.println("Desktop API is not supported!");
              }
        }

    @FXML
    void openSuggestion2(ActionEvent event) {
      
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                  Desktop.getDesktop().browse(new URI(urls.get(1)));
                } catch (Exception e) {
                  e.printStackTrace();
                  // Handle potential exceptions (e.g., invalid URL)
                  System.out.println("Failed to open browser!");
                }
              } else {
                // Desktop API not supported, display a message
                System.out.println("Desktop API is not supported!");
              }
        }

    @FXML
    void openSuggestion3(ActionEvent event) {
      
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                  Desktop.getDesktop().browse(new URI(urls.get(2)));
                } catch (Exception e) {
                  e.printStackTrace();
                  // Handle potential exceptions (e.g., invalid URL)
                  System.out.println("Failed to open browser!");
                }
              } else {
                // Desktop API not supported, display a message
                System.out.println("Desktop API is not supported!");
              }
        }

    @FXML
    void powerOff(ActionEvent event) {
        System.exit(0);
    }
}
