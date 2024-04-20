package com.xbirds;


class WeatherInfo {
    private double avgmaxTemp;
    private double avgminTemp;
    private double totalmaxTemp;
    private double totalminTemp;

    private int weatherCode;
    public WeatherInfo(double m1,double m2,double m3,double m4, int c){
        avgmaxTemp= m1;
        avgminTemp =m2;
        totalmaxTemp= m1;
        totalminTemp =m2;
        weatherCode=c;
    }
    @Override
    public String toString() {
        return "The Average Max Temperature for 14 days is: " + avgmaxTemp + "\n" +
               "The Average Min Temperature for 14 days is: " + avgminTemp + "\n" +
               "Total Max Temperature for 14 days is: " + totalmaxTemp + "\n" +
               "Total Min Temperature for 14 days is: " + totalminTemp + "\n" +
                "The Weather Codes for each day are: " + weatherCode;
    }
    public double getAvgMaxTemp() {
        return avgmaxTemp;
    }

   

    public double getAvgMinTemp() {
        return avgminTemp;
    }

  

    public double getTotalMaxTemp() {
        return totalmaxTemp;
    }

   

    public double getTotalMinTemp() {
        return totalminTemp;
    }

   

    public int getWeatherCode() {
        return weatherCode;
    }

  
}