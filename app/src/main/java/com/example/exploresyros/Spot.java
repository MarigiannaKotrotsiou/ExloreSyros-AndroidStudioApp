package com.example.exploresyros;

import android.content.Context;
import androidx.annotation.NonNull;

public class Spot {

    private String name;
    private int numOfPins;
    private int thumbnailResourceID;
    private String imageContentDescription;
    private int descriptionResourceId;
    private String tag;
    private String description;

    public Spot(String name, int numOfPins, int thumbnailResourceID, int descriptionResourceId, String tag) {
        this.name = name;
        this.numOfPins = numOfPins;
        this.thumbnailResourceID = thumbnailResourceID;
        this.descriptionResourceId = descriptionResourceId;
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getNumOfPins() {
        return numOfPins;
    }

    public void setNumOfPins(int numOfPins) {
        this.numOfPins = numOfPins;
    }

    public int getThumbnailResourceID() {
        return thumbnailResourceID;
    }

    public void setThumbnailResourceID(int thumbnailResourceID) {
        this.thumbnailResourceID = thumbnailResourceID;
    }

    public String getImageContentDescription() {
        return imageContentDescription;
    }

    public void setImageContentDescription(String imageContentDescription) {
        this.imageContentDescription = imageContentDescription;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public void setDescriptionResourceId(int descriptionResourceId) {
        this.descriptionResourceId = descriptionResourceId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription(Context context) {
        return context.getString(descriptionResourceId);
    }
}
