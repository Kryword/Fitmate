package com.kryword.fitmate.Models;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Exercise implements Serializable{
    private String id;
    private String name;
    private String description;
    private Uri image;

    public Exercise() {
    }

    public Exercise(String id, String name, String description, Uri image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject exercise = new JSONObject();
        exercise.put("id", id);
        exercise.put("name", name);
        exercise.put("description", description);
        exercise.put("image", image);
        return exercise;
    }
}
