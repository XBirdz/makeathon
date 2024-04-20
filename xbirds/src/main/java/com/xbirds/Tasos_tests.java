package com.xbirds;
import java.util.*;
public class Tasos_tests {
    public static void test(){
        WeatherHandler w = new WeatherHandler();
        List<String> features = new ArrayList<>();
        features.add("pool");
        features.add("beachfront");
        w.init( features,"ski", "snowy","far","Athens","cheap","couple","winter");
       
    }
}
