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
    
}