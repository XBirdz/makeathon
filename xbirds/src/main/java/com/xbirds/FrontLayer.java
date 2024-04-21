package com.xbirds;
import java.util.*;
import javafx.util.Pair;
public class FrontLayer {
    public static List<Pair<CityInfo,WeatherInfo>> giveUserData(List<String> features,String type, String weatherInp, String distance, String location, String budget, String company, String season,String checkinDay, String checkinMonth, String checkinYear, String checkoutDay, String checkoutMonth, String checkoutYear){
        WeatherHandler w = new WeatherHandler();
       return w.init(features, type, weatherInp, distance, location, budget, company, season,checkinDay, checkinMonth, checkinYear, checkoutDay, checkoutMonth, checkoutYear);
    } 
}
