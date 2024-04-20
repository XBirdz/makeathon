package com.xbirds;
import java.util.ArrayList;
import java.util.List;
public class WeatherHandler {
    private  List<String> cities;
    private  List<CityInfo> info = new ArrayList<>();
    private  String[] weathers;
    private  String type="ski";
    public  void init(String input, String type){
        this.type = type;
        cities = GptConnector.handleUserInp(input);
        for (String city : cities) {
            System.out.println(city);
            String[] parts = city.split("[,\\s]+");
            String city_name=parts[0];
            
            
            info.add(TravelmythAPI.createInfo(city_name, type));

        }
        for (CityInfo cityInfo : info) {
            System.out.println(cityInfo.getName());
            weather.weatherdata(weather.requestWeather(Double.parseDouble(cityInfo.getLatitude()), Double.parseDouble(cityInfo.getLongitude()), " "));
        } 
        
    }

    
}
