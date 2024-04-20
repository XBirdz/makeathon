package com.xbirds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class WeatherCodes {

    HashMap<Integer, String> weatherMap = new HashMap<>();

    private ArrayList<String>  addDescriptions(){
        ArrayList<String> descriptions = new ArrayList<>();
        
        descriptions.add("Clear sky");
        descriptions.add("Mainly clear, partly cloudy, and overcast");
        descriptions.add("Fog and depositing rime fog");
        descriptions.add("Drizzle: Light, moderate, and dense intensity");
        descriptions.add("Freezing Drizzle: Light and dense intensity");
        descriptions.add("Rain: Slight, moderate, and heavy intensity");
        descriptions.add("Freezing Rain: Light and heavy intensity");
        descriptions.add("Snow fall: Slight, moderate, and heavy intensity");
        descriptions.add("Snow grains");
        descriptions.add("Rain showers: Slight, moderate, and violent");
        descriptions.add("Snow showers slight and heavy");
        descriptions.add("Thunderstorm: Slight or moderate");
        descriptions.add("Thunderstorm with slight and heavy hail");

        return descriptions;
    }


    private void  setValues(int[] keys , String[] descriptions){
        for (description : descriptions)
            IntStream.of(keys).forEach(key -> weatherMap.put(key, description));
    }

    public WeatherCodes() {

        // Add your weather data
        weatherMap.put(0, "Clear sky");
        
        int[] keys = {1, 2, 3}; 
        String description = new String("Mainly clear, partly cloudy, and overcast");
        IntStream.of(keys).forEach(key -> weatherMap.put(key, description));



        description.replace(description, "Fog and depositing rime fog");
        keys = new int [] {45,48};



        weatherMap.put(45, "Fog");
        weatherMap.put(48, "Depositing rime fog");
        // ... and so on

        // Example: How to print the contents of the map
        System.out.println(weatherMap);  
        
    }
}
