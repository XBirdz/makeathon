package com.xbirds;

public class InputManager {

    public static String promptCreator(String activity, String weather, String distance, String location, String budget, String company){
        String prompt = "Hi i want a" +activity+"destintion for a city break. I live in athens. My preferred weather is"+weather+"I want to travel"+distance+".I live in"+
        location+".My budegt is"+budget+ "I am travelling as"+company;
        return prompt;
    }
}