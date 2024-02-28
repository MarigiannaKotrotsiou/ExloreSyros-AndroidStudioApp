package com.example.exploresyros;

import androidx.annotation.NonNull;

import org.osmdroid.util.GeoPoint;

public class Pin
{
    private String PinGroup;
    private String title;
    private GeoPoint geopoint;
    private int imageResourceID;
    private int pinResourceID;
    private final static int DEFAULT_PIN_RESOURCE_ID = R.drawable.baseline_location_on_24;

    // στοιχεία για κάρτες
    public Pin(String PinGroup, GeoPoint geopoint, int imageResourceID){
        this.PinGroup = PinGroup;
        this.title = title;
        this.geopoint = geopoint;
        this.imageResourceID = imageResourceID;
        this.pinResourceID = DEFAULT_PIN_RESOURCE_ID;
    }

    public String getPinGroup() {
        return PinGroup;
    }

    public void setPinGroup(String POIGroup) {
        this.PinGroup = POIGroup;
    }

    public @NonNull
    String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public GeoPoint getGeopoint() {
        return geopoint;
    }

    public void setGeopoint(GeoPoint geopoint) {
        this.geopoint = geopoint;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public int getPinResourceID() {
        return pinResourceID;
    }

    public void setPinResourceID(int pinResourceID) {
        this.pinResourceID = pinResourceID;
    }

    public static int getDefaultPinResourceId() {
        return DEFAULT_PIN_RESOURCE_ID;
    }

}

