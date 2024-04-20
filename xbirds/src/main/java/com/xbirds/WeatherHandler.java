package com.xbirds;
import java.util.List;
public class WeatherHandler {
    private static List<String> cities;
    private static String[] weathers;
    private static String type;
    public static void init(String input){
        cities = GptConnector.handleUserInp(input);
        for (String city : cities) {
            TravelmythAPI.createInfo(city, type);
        }
    }
    
}
