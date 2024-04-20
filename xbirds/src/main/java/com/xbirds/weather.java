package com.xbirds;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class Weather {
    class WeatherData {
        @JsonProperty("daily")
        private DailyData dailyData;
    
        public DailyData getDailyData() {
            return dailyData;
        }
    }
    
    class DailyData {
        @JsonProperty("temperature_2m_max")
        private List<Double> maxTemperatures;
    
        @JsonProperty("temperature_2m_min")
        private List<Double> minTemperatures;

        @JsonProperty("weather_codes")
        private List<Integer> weatherCodes;
    
        public List<Double> getMaxTemperatures() {
            return maxTemperatures;
        }
    
        public List<Double> getMinTemperatures() {
            return minTemperatures;
        }
        public List<Integer> getWeatherCodes() {
            return weatherCodes;
        }
    }
    public static String requestWeather(double latitude, double longitude, String destination ){
        try{
        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&daily=weather_code,temperature_2m_max,temperature_2m_min&timezone=auto&forecast_days=14";


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
    public static void weatherdata(String jsonObj){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            
            WeatherData weatherData = objectMapper.readValue(jsonObj, WeatherData.class);

            
            List<Integer> weatherCodes = weatherData.getDailyData().getWeatherCodes();
            List<Double> maxTemperatures = weatherData.getDailyData().getMaxTemperatures();
            List<Double> minTemperatures = weatherData.getDailyData().getMinTemperatures();

            double avgMaxTemp=0;
            double avgMinTemp=0;
            double maxTemp = Double.MIN_VALUE;
            double minTemp = Double.MAX_VALUE;
            int maxTempIndex = -1;
            int minTempIndex = -1;

            for (int i = 0; i < maxTemperatures.size(); i++) {
                double maxTempOfDay = maxTemperatures.get(i);
                double minTempOfDay = minTemperatures.get(i);
                int weatherCode = weatherCodes.get(i);

                if (maxTempOfDay > maxTemp) {
                    maxTemp = maxTempOfDay;
                    maxTempIndex = i;
                    avgMaxTemp+=maxTempOfDay;
                }
                if (minTempOfDay < minTemp) {
                    minTemp = minTempOfDay;
                    minTempIndex = i;
                    avgMinTemp+=minTempOfDay;
                }

                
            
                System.out.println("Max Temperature: " + maxTempOfDay + "°C");
                System.out.println("Min Temperature: " + minTempOfDay + "°C");
                System.out.println("Weather Code: " + weatherCode);
                System.out.println();
            }

           
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
}

