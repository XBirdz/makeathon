package com.xbirds;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class UnsplashAPIclient {
    public static String fetchPhotos(String keyword) {
       
        String baseUrl = "https://api.unsplash.com/photos/random";

    
        String accessKey = "l07591426f_Fyl8RBgsHA4Muod0WtnrdQY7l6_akooo";

    
        String query = "travel-" + keyword; 
        String orientation = "landscape"; 
        int count = 1; 

      
        String urlString = "https://api.unsplash.com/photos/random?client_id="+accessKey+"&orientation=landscape&query="+query;
        System.err.println(urlString);

        try {
        
            URL url = new URL(urlString);

           
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

       
            int responseCode = connection.getResponseCode();

            
            if (responseCode == HttpURLConnection.HTTP_OK) {
             
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            
            } else {
                System.out.println("Failed to retrieve photos. Status code: " + responseCode);
            }

            
            connection.disconnect();
            return "Error";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }
    public static BufferedImage downloadPhoto(URL url) {
        try {
        
            BufferedImage image = ImageIO.read(url);

            
          return image;

        } catch (IOException e) {
            e.printStackTrace();
        }
}
public static String jsonextract(String jsonString){
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String name = jsonNode.get("urls").get("regular").asText();
        return name;
} catch (Exception e) {
    e.printStackTrace();
    return null;
}
}
}
