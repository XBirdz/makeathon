package com.xbirds.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import com.xbirds.App;
import com.xbirds.UnsplashAPIclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class IntroPageController {

    @FXML
    private ImageView showcaseImage;

    @FXML
    void initialize() {
        updateImage();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateImage();
            }
        };

        // Schedule the task to run every 5 seconds (5000 milliseconds)
        timer.scheduleAtFixedRate(task, 0, 5000);
    }

    private void updateImage() {
        BufferedImage image = UnsplashAPIclient.getphoto("nature");
        byte[] imageBytes = convertToByteArray(image);

        // Create JavaFX Image from byte array
        Image fxImage = new Image(new ByteArrayInputStream(imageBytes));
        showcaseImage.setImage(fxImage);
        showcaseImage.setFitHeight(400);
        showcaseImage.setFitWidth(760);
        showcaseImage.setPreserveRatio(false);

        Rectangle clip = new Rectangle();
        clip.setWidth(showcaseImage.getFitWidth());
        clip.setHeight(showcaseImage.getFitHeight());
        clip.setArcWidth(20); // the arc width to change the roundness of the corners
        clip.setArcHeight(20); // Adjust the arc height to change the roundness of the corners

        // Set the clip to the ImageView
        showcaseImage.setClip(clip);
    }

    private byte[] convertToByteArray(BufferedImage bufferedImage) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @FXML
    void power(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void openStartPage(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StartPage.fxml")); 
            Parent root;
            try {
                    root = loader.load();
                    Scene startPageScene = new Scene(root, 800, 500);
                    startPageScene.setFill(null);
                    App.window.setScene(startPageScene);
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

}