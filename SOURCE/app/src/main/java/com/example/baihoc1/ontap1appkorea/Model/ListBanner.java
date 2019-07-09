package com.example.baihoc1.ontap1appkorea.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListBanner implements Serializable {

@SerializedName("urlBanner")
@Expose
public String urlBanner;
@SerializedName("place")
@Expose
public Place place;

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}