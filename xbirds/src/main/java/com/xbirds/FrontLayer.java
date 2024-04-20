package com.xbirds;
import java.util.*;
public class FrontLayer {
    public static void giveUserData(List<String> features,String type, String weatherInp, String distance, String location, String budget, String company, String season){
        WeatherHandler w = new WeatherHandler();
        w.init(features, type, weatherInp, distance, location, budget, company, season);
    } 
}
