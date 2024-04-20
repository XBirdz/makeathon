package com.xbirds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

import java.util.List;
public class WeatherHandler {
    private  List<String> cities;
    private List<String> top3String;
    private  List<CityInfo> info = new ArrayList<>();
    private  List<CityInfo> top3 = new ArrayList<>();
    private  List<WeatherInfo> weathers = new ArrayList();
    public  List<Pair<CityInfo,WeatherInfo>> init(List<String> features,String type, String weatherInp, String distance, String location, String budget, String company, String season){
        cities = GptConnector.handleUserInp(InputManager.promptCreator(type, weatherInp, distance, location, budget, company, season));
        for (String city : cities) {
            System.out.println(city);
            
            
            info.add(TravelmythAPI.createInfo(city, features));

        }
        
        for (CityInfo cityInfo : info) {
            weathers.add(weather.weatherdata(weather.requestWeather(Double.parseDouble(cityInfo.getLatitude()), Double.parseDouble(cityInfo.getLongitude()), " ")));
        }
        List<String> list = Arrays.asList(weatherInp.split(","));
        List<Integer> top3Int = Similarity.similar(weathers, list);
        List<Pair<CityInfo, WeatherInfo>> res = new ArrayList<>();

        for (Integer i : top3Int) {
            res.add(new Pair<>(info.get(i), weathers.get(i)));
        }        
        for (CityInfo c : top3) {
            System.out.println(c.toString());
        }
        return res;
    }

    
}
