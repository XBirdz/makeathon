package com.xbirds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class WeatherCodes {

    public static void setCodes() {

        HashMap<Integer, String> weatherMap = new HashMap<>();

        // Clear, Partly Cloudy Conditions
        weatherMap.put(0, "Clear sky");
        weatherMap.put(1, "Mainly clear");
        weatherMap.put(2, "Partly cloudy");
        weatherMap.put(3, "Overcast");

        // Fog
        weatherMap.put(45, "Fog");
        weatherMap.put(48, "Depositing rime fog");

        // Drizzle
        weatherMap.put(51, "Drizzle: Light");
        weatherMap.put(53, "Drizzle: Moderate");
        weatherMap.put(55, "Drizzle: Dense");

        // Freezing Drizzle
        weatherMap.put(56, "Freezing Drizzle: Light");
        weatherMap.put(57, "Freezing Drizzle: Dense");

        // Rain
        weatherMap.put(61, "Rain: Slight");
        weatherMap.put(63, "Rain: Moderate");
        weatherMap.put(65, "Rain: Heavy");

        // Freezing Rain
        weatherMap.put(66, "Freezing Rain: Light");
        weatherMap.put(67, "Freezing Rain: Heavy");

        // Snow
        weatherMap.put(71, "Snow fall: Slight");
        weatherMap.put(73, "Snow fall: Moderate");
        weatherMap.put(75, "Snow fall: Heavy");

        // Snow Grains
        weatherMap.put(77, "Snow grains");

        // Rain Showers
        weatherMap.put(80, "Rain showers: Slight");
        weatherMap.put(81, "Rain showers: Moderate");
        weatherMap.put(82, "Rain showers: Violent");

        // Snow Showers
        weatherMap.put(85, "Snow showers: Slight");
        weatherMap.put(86, "Snow showers: Heavy");

        // Thunderstorm (Note: Your input had an asterisk, I'll adjust)
        weatherMap.put(95, "Thunderstorm: Slight or moderate"); 
        weatherMap.put(96, "Thunderstorm with slight hail"); 
        weatherMap.put(99, "Thunderstorm with heavy hail");        
    }
}
