package com.xbirds;
import java.util.*;
public class Tasos_tests {
    public static void test(){
        WeatherHandler w = new WeatherHandler();
        List<String> features = new ArrayList<>();
        features.add("pool");
       
        w.init( features,"ski", "snowy,no rain","far","Athens","cheap","couple","winter");
       //Embeddings.encode("null", features);
       //Embeddings embeddings = new Embeddings();
       //List<Integer> closestIndices = embeddings.findClosestPhraseIndices("water",features);
        //System.out.println("Indices of closest phrases to \"" + "sand" + "\": " + closestIndices);
    }
    }

