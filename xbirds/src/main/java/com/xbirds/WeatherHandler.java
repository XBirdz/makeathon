package com.xbirds;
import java.util.ArrayList;
import java.util.List;
public class WeatherHandler {
    private  List<String> cities;
    private List<String> top3String;
    private  List<CityInfo> info = new ArrayList<>();
    private  List<CityInfo> top3 = new ArrayList<>();
    private  List<WeatherInfo> weathers = new ArrayList();
    public  void init(String activity, String weatherInp, String distance, String location, String budget, String company, String season){
        cities = GptConnector.handleUserInp(InputManager.promptCreator(activity, weatherInp, distance, location, budget, company, season));
        for (String city : cities) {
            System.out.println(city);
            
            
            info.add(TravelmythAPI.createInfo(city, activity));

        }
        
        for (CityInfo cityInfo : info) {
            weathers.add(weather.weatherdata(weather.requestWeather(Double.parseDouble(cityInfo.getLatitude()), Double.parseDouble(cityInfo.getLongitude()), " ")));
        }
        /*top3String = GptConnector.selection(info, weathers, activity, weatherInp);
        for(int i =0;i<top3String.size();i++){
            for(int j =0;j<info.size();j++){
                if(top3String.get(i)==info.get(j).getName()){
                    top3.add(info.get(j));
                    System.out.println(top3.get(i).getName());
                }
            }
        }
        for (CityInfo c : top3) {
            System.out.println(c.toString());
        }*/
    }

    
}
