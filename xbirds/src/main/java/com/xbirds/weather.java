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
import java.util.HashMap;
import java.util.Map;


public class weather {


    public static class WeatherData {
        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("generationtime_ms")
        private double generationTimeMs;

        @JsonProperty("utc_offset_seconds")
        private int utcOffsetSeconds;

        @JsonProperty("timezone")
        private String timezone;

        @JsonProperty("timezone_abbreviation")
        private String timezoneAbbreviation;

        @JsonProperty("elevation")
        private double elevation;

        @JsonProperty("daily_units")
        private DailyUnits dailyUnits;

        @JsonProperty("daily")
        private DailyData dailyData;

        // Getters and setters
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getGenerationTimeMs() {
            return generationTimeMs;
        }

        public void setGenerationTimeMs(double generationTimeMs) {
            this.generationTimeMs = generationTimeMs;
        }

        public int getUtcOffsetSeconds() {
            return utcOffsetSeconds;
        }

        public void setUtcOffsetSeconds(int utcOffsetSeconds) {
            this.utcOffsetSeconds = utcOffsetSeconds;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getTimezoneAbbreviation() {
            return timezoneAbbreviation;
        }

        public void setTimezoneAbbreviation(String timezoneAbbreviation) {
            this.timezoneAbbreviation = timezoneAbbreviation;
        }

        public double getElevation() {
            return elevation;
        }

        public void setElevation(double elevation) {
            this.elevation = elevation;
        }

        public DailyUnits getDailyUnits() {
            return dailyUnits;
        }

        public void setDailyUnits(DailyUnits dailyUnits) {
            this.dailyUnits = dailyUnits;
        }

        public DailyData getDailyData() {
            return dailyData;
        }

        public void setDailyData(DailyData dailyData) {
            this.dailyData = dailyData;
        }
    }

    public static class DailyUnits {
        @JsonProperty("time")
        private String time;

        @JsonProperty("weather_code")
        private String weatherCode;

        @JsonProperty("temperature_2m_max")
        private String maxTemperature;

        @JsonProperty("temperature_2m_min")
        private String minTemperature;

        // Getters and setters
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(String weatherCode) {
            this.weatherCode = weatherCode;
        }

        public String getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(String maxTemperature) {
            this.maxTemperature = maxTemperature;
        }

        public String getMinTemperature() {
            return minTemperature;
        }

        public void setMinTemperature(String minTemperature) {
            this.minTemperature = minTemperature;
        }
    }

    public static class DailyData {
        @JsonProperty("time")
        private List<String> time;

        @JsonProperty("weather_code")
        private List<Integer> weatherCodes;

        @JsonProperty("temperature_2m_max")
        private List<Double> maxTemperatures;

        @JsonProperty("temperature_2m_min")
        private List<Double> minTemperatures;

        // Getters and setters
        public List<String> getTime() {
            return time;
        }

        public void setTime(List<String> time) {
            this.time = time;
        }

        public List<Integer> getWeatherCodes() {
            return weatherCodes;
        }

        public void setWeatherCodes(List<Integer> weatherCodes) {
            this.weatherCodes = weatherCodes;
        }

        public List<Double> getMaxTemperatures() {
            return maxTemperatures;
        }

        public void setMaxTemperatures(List<Double> maxTemperatures) {
            this.maxTemperatures = maxTemperatures;
        }

        public List<Double> getMinTemperatures() {
            return minTemperatures;
        }

        public void setMinTemperatures(List<Double> minTemperatures) {
            this.minTemperatures = minTemperatures;
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
    
            double totalMaxTemp = Double.MIN_VALUE;
            double totalMinTemp = Double.MAX_VALUE;
            int maxTempIndex = -1;
            int minTempIndex = -1;
    
            double sumMaxTemp = 0;
            double sumMinTemp = 0;
    
            // HashMap to store occurrences of each weather code
            Map<Integer, Integer> weatherCodeSummary = new HashMap<>();
    
            for (int i = 0; i < maxTemperatures.size(); i++) {
                double maxTempOfDay = maxTemperatures.get(i);
                double minTempOfDay = minTemperatures.get(i);
                int weatherCode = weatherCodes.get(i);
    
                // Update total max and min temperatures
                if (maxTempOfDay > totalMaxTemp) {
                    totalMaxTemp = maxTempOfDay;
                    maxTempIndex = i;
                }
                if (minTempOfDay < totalMinTemp) {
                    totalMinTemp = minTempOfDay;
                    minTempIndex = i;
                }
    
                // Update sum of temperatures for later calculation of averages
                sumMaxTemp += maxTempOfDay;
                sumMinTemp += minTempOfDay;
    
                // Update weather code summary
                weatherCodeSummary.put(weatherCode, weatherCodeSummary.getOrDefault(weatherCode, 0) + 1);
    
            }
    
            // Calculate average temperatures
            double avgMaxTemp = sumMaxTemp / maxTemperatures.size();
            double avgMinTemp = sumMinTemp / minTemperatures.size();
    
            System.out.println("Total Max Temperature: " + totalMaxTemp + "°C");
            System.out.println("Total Min Temperature: " + totalMinTemp + "°C");
            System.out.println("Average Max Temperature: " + avgMaxTemp + "°C");
            System.out.println("Average Min Temperature: " + avgMinTemp + "°C");
    
            // Print weather code summary
            System.out.println("Weather Code Summary:");
            for (Map.Entry<Integer, Integer> entry : weatherCodeSummary.entrySet()) {
                System.out.println("Weather Code " + entry.getKey() + ": " + entry.getValue() + " occurrences");
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
}

