package com.xbirds;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;;


public class TravelmythAPI {
        private static List<CityInfo> citiesInfo = new ArrayList<>();
        public static List<CityInfo> getInfo(){
            return citiesInfo;
        }

        public static void createInfo(String destination, String type){
            citiesInfo.add(jsonextract(apireq(destination, type)));
        }
        public static String apireq(String destination, String type){
            try{
            String apiKey = "myTeam";
            String urlString = "https://www.travelmyth.gr/api_chat_makeathon.php?destination=" + destination + "&lang=en&categories=" + type + "&apiKey=" + apiKey;
            URL url = new URL(urlString);
            System.out.println(urlString);
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
    public static CityInfo jsonextract(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            String name = jsonNode.get("name").asText();
            String destUrl = jsonNode.get("url").asText();
            String latitude = jsonNode.get("latitude").asText();
            String longitude = jsonNode.get("longitude").asText();
            
            // Create and return a CityInfo object
            return new CityInfo(name, destUrl, latitude, longitude);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


