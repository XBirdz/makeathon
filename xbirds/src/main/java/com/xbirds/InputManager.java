package com.xbirds;

public class InputManager {

    public static String promptCreator(String activity, String weather, String distance, String location, String budget, String company, String season){
        String prompt = "Hi i want a" +activity+"destintion for a city break. I live in athens. My preferred weather is"+weather+"I want to travel"+distance+".I live in"+
        location+".My budegt is"+budget+ "I am travelling as"+company;


        /*String prompt = " The user is looking to plan a vacation and has provided the following criteria: * **Activity:** " + activity + " * **Weather:** " + weather + " * **Price Range:** " + budget +"Distance:"+distance+"**Who he is traveling with**"+company+ " Based on this information,"+
        " please recommend 10 top destinations that would be a good fit for the user's trip."+
        " When making recommendations, consider factors like: * **Weather:** Does the destination's climate during the travel dates match the user's preference? * **Activities:** Does the destination offer opportunities for the user's desired activity?  "+
        "* **Cost:** Does the average price of accommodation during the travel dates fall within the user's budget?"+
        " * **Seasonality:**"+season+" Is the destination a good choice for the chosen activity during the specified travel dates (e.g., not recommending skiing locations in summer)? "+
        "* **Popularity:** While including popular destinations, consider suggesting some hidden gems as well. ";*/ 


        return prompt;
    }
}