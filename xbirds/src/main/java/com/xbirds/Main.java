package com.xbirds;

public class Main {
    public static void main(String args[]){
        System.out.println(TravelmythAPI.apireq("Athens", "ski"));
        System.out.println(UnsplashAPIclient.jsonextract(UnsplashAPIclient.fetchPhotos("sunny")));
    }
}
