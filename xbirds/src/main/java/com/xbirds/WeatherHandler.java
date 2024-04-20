package com.xbirds;
import java.util.ArrayList;
import java.util.List;
public class WeatherHandler {
    private  List<String> cities;
    private  List<CityInfo> info = new ArrayList<>();
    private  List<WeatherInfo> weathers = new ArrayList();
    public  void init(String activity, String weatherInp){
        cities = GptConnector.handleUserInp(InputManager.promptCreator(activity, weatherInp));
        for (String city : cities) {
            System.out.println(city);
            String[] parts = city.split("[,\\s]+");
            String city_name=parts[0];
            
            
            info.add(TravelmythAPI.createInfo(city_name, activity));

        }
        for (CityInfo cityInfo : info) {
            weathers.add(weather.weatherdata(weather.requestWeather(Double.parseDouble(cityInfo.getLatitude()), Double.parseDouble(cityInfo.getLongitude()), " ")));
        } 
        
    }

    
}
