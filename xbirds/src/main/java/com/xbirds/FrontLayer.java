package com.xbirds;
import java.util.*;
import javafx.util.Pair;
public class FrontLayer {
    public static List<Pair<CityInfo,WeatherInfo>> giveUserData(List<String> features,String type, String weatherInp, String distance, String location, String budget, String company, String season,String checkinDay, String checkinMonth, String checkinYear, String checkoutDay, String checkoutMonth, String checkoutYear){
        WeatherHandler w = new WeatherHandler();
       return w.init(features, type, weatherInp, distance, location, budget, company, season,checkinDay, checkinMonth, checkinYear, checkoutDay, checkoutMonth, checkoutYear);
    }
    public static void test(){
        List<String> features = new ArrayList<>();
        features.add("pool");
        features.add("haunted");
        String type = "beach, surf";
        String weather = "sunny, no rains, no clouds";
        String distance = "far";
        String  location = "Athens";
        String budget = "I dont care";
        String company = "friend group";
        String sea = "Summer";
        List<Pair<CityInfo,WeatherInfo>> res = giveUserData(features, type, weather, distance, location, budget, company, sea, "15", "06", "2024", "17", "06", "2024");
        for (Pair<CityInfo,WeatherInfo> pair : res) {
            System.out.println(pair.getKey().toString()+" "+pair.getValue().toString());
        }
    } 
}
