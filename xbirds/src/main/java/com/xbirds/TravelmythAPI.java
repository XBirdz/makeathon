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

        public static CityInfo createInfo(String destination, List<String> type){
            return jsonextract(apireq(destination, type));
        }
        public static String apireq(String destination, List <String> type){
            try{
            StringBuilder sb = new StringBuilder();
            for (String string : type) {
                sb.append(string).append(",");
            }
            String types = sb.toString();
            String apiKey = "myTeam";
            String urlString = "https://www.travelmyth.gr/api_chat_makeathon_multi.php?destination="+destination+"&lang=en&categories="+types+"&apiKey=myTeam";
            System.out.println(urlString);
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
    public static CityInfo jsonextract(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
    
            CityInfo cityWithMostHotels = null;
            int maxNumberOfHotels = Integer.MIN_VALUE;
    
            // Iterate through each location node in the JSON
            for (JsonNode locationNode : rootNode) {
                String name = locationNode.get("name").asText();
                String destUrl = locationNode.get("url").asText();
                String latitude = locationNode.get("latitude").asText();
                String longitude = locationNode.get("longitude").asText();
                String numberOfHotelsStr = locationNode.get("number_of_hotels").asText();
                String price = locationNode.get("average_price_EUR").asText();
                int numberOfHotels = Integer.parseInt(numberOfHotelsStr);
    
                // Check if the current location has more hotels than the previous maximum
                if (numberOfHotels > maxNumberOfHotels) {
                    maxNumberOfHotels = numberOfHotels;
                    cityWithMostHotels = new CityInfo(name, destUrl, latitude, longitude,price);
                }
            }
    
            // Return the location with the highest number of hotels
            return cityWithMostHotels;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


