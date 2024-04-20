package com.xbirds;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Similarity {

   public static List<Integer> similar(List<WeatherInfo> wi, List<String> feautures){
            List<Integer> res = new ArrayList<>();
            res.add(1);
            res.add(0);
            res.add(2);
            for (String f : feautures) {
                if (wi.size()==3){
                    break;
                }


            }
            return  res;
   }
}
