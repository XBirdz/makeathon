package com.xbirds.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
        timer.scheduleAtFixedRate(task, 0, 50000);
    }

    private void updateImage() {
        File file = new File("path/to/your/image.jpg");
        BufferedImage image = new BufferedImage(100, 100, 1);
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //BufferedImage image = UnsplashAPIclient.getphoto("nature");
        byte[] imageBytes = convertToByteArray(image);

        // Create JavaFX Image from byte array
        Image fxImage = new Image(new ByteArrayInputStream(imageBytes));
        showcaseImage.setImage(fxImage);
        showcaseImage.setFitHeight(500);
        showcaseImage.setFitWidth(960);
        showcaseImage.setPreserveRatio(false);

        Rectangle clip = new Rectangle();
        clip.setWidth(960);
        clip.setHeight(500);
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
                    Scene startPageScene = new Scene(root, 1000, 650);
                    startPageScene.setFill(null);
                    App.window.setScene(startPageScene);
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

}