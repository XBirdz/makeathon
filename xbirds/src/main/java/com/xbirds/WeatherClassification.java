package com.xbirds;

import java.util.Map;

public class WeatherClassification {

    public static int classify(Map<Integer,Integer> codes){
        int maxDistanceNumber = 0;
        int maxDistance = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : codes.entrySet()) {
            int num = entry.getKey();
            int distance = Math.abs(num % 10 ); 
            if (distance > maxDistance) {
                maxDistance = distance;
                maxDistanceNumber = num;
            }
        }   
        return maxDistanceNumber;
   
    }
}