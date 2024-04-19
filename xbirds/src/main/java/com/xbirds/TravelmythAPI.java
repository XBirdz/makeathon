package com.xbirds;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;

public class TravelmythAPI {

        public static String apireq(String destination, String type){
            try{
            String apiKey = "myTeam";
            String urlString = "https://www.travelmyth.gr/api_chat_makeathon.php?destination=" + destination + "&lang=en&categories=" + type + "&apiKey=" + apiKey;
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
    
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
    
                return response.toString();
            } else {
                
                return "Error: HTTP response code " + responseCode;
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
    public static void main(String [] args ){
        System.out.println(apireq("Athens","ski"));
    }
}
