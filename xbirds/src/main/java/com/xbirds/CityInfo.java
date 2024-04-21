package com.xbirds;

public class CityInfo {
    private String name;
    private String url;
    private String latitude;
    private String longitude;
    private String avgPrice;

    public CityInfo(String name, String url, String latitude, String longitude, String price) {
        this.name = name;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avgPrice = price;
    }
    @Override
    public String toString() {
        return "CityInfo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setUrl (String checkinDay, String checkinMonth, String checkinYear, String checkoutDay, String checkoutMonth, String checkoutYear){
        this.url+="&checkin_day="+checkinDay+"&checkin_month="+checkinMonth+"&checkin_year="+checkinYear+"&checkout_day="+checkoutDay+"&checkout_month="+checkoutMonth+"&checkout_year="+checkoutYear;
    }
}