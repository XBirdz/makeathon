package com.xbirds;

public class CityInfo {
    private String name;
    private String url;
    private double latitude;
    private double longitude;

    public CityInfo(String name, String url, double latitude, double longitude) {
        this.name = name;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}