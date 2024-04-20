package com.xbirds;
import java.util.List;
public class WeatherHandler {
    private static List<String> cities;
    private static List<CityInfo> info;
    private static String[] weathers;
    private static String type="ski";
    public static void init(String input){
        cities = GptConnector.handleUserInp(input);
        for (String city : cities) {
            System.out.println(city);
            String[] parts = city.split("[,\\s]+");
            String city_name=parts[0];
            for (String part : parts) {
                System.out.println(part);
            }
            TravelmythAPI.createInfo(city_name, type);
            info = TravelmythAPI.getInfo();

        }
        info = TravelmythAPI.getInfo();
        for (CityInfo string : info) {
            System.out.println(string.toString());
        }
    }

    
}
