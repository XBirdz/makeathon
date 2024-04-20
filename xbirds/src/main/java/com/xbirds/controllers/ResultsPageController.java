package com.xbirds.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.net.URI;

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

    @FXML
    void openSuggestion1(ActionEvent event) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                  Desktop.getDesktop().browse(new URI("www.google.com"));
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
                  Desktop.getDesktop().browse(new URI("www.google.com"));
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
                  Desktop.getDesktop().browse(new URI("www.google.com"));
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
