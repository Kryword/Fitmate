package com.kryword.fitmate.Models;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class SessionExercise extends Exercise implements Serializable{
    private int setsMin;
    private int repetitionsMin;
    private int setsMax;
    private int repetitionsMax;
    private int waitMin;
    private int waitMax;
    private int weightMin;
    private int weightMax;

    public SessionExercise() {
    }

    public SessionExercise(String id, String name, String description, Uri image, int setsMin, int repetitionsMin, int setsMax, int repetitionsMax, int waitMin, int waitMax) {
        super(id, name, description, image);
        this.setsMin = setsMin;
        this.repetitionsMin = repetitionsMin;
        this.setsMax = setsMax;
        this.repetitionsMax = repetitionsMax;
        this.waitMin = waitMin;
        this.waitMax = waitMax;
    }

    public SessionExercise(String id, String name, String description, Uri image, int setsMin, int repetitionsMin, int setsMax, int repetitionsMax, int waitMin, int waitMax, int weightMin, int weightMax) {
        super(id, name, description, image);
        this.setsMin = setsMin;
        this.repetitionsMin = repetitionsMin;
        this.setsMax = setsMax;
        this.repetitionsMax = repetitionsMax;
        this.waitMin = waitMin;
        this.waitMax = waitMax;
        this.weightMin = weightMin;
        this.weightMax = weightMax;
    }

    public int getWeightMin() {
        return weightMin;
    }

    public void setWeightMin(int weightMin) {
        this.weightMin = weightMin;
    }

    public int getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(int weightMax) {
        this.weightMax = weightMax;
    }

    public int getSetsMin() {
        return setsMin;
    }

    public void setSetsMin(int setsMin) {
        this.setsMin = setsMin;
    }

    public int getRepetitionsMin() {
        return repetitionsMin;
    }

    public void setRepetitionsMin(int repetitionsMin) {
        this.repetitionsMin = repetitionsMin;
    }

    public int getSetsMax() {
        return setsMax;
    }

    public void setSetsMax(int setsMax) {
        this.setsMax = setsMax;
    }

    public int getRepetitionsMax() {
        return repetitionsMax;
    }

    public void setRepetitionsMax(int repetitionsMax) {
        this.repetitionsMax = repetitionsMax;
    }

    public int getWaitMin() {
        return waitMin;
    }

    public void setWaitMin(int waitMin) {
        this.waitMin = waitMin;
    }

    public int getWaitMax() {
        return waitMax;
    }

    public void setWaitMax(int waitMax) {
        this.waitMax = waitMax;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject sessionExercise = new JSONObject();
        sessionExercise.put("name", getName());
        sessionExercise.put("description", getDescription());
        sessionExercise.put("image", getImage());
        sessionExercise.put("setsMin", setsMin);
        sessionExercise.put("setsMax", setsMin);
        sessionExercise.put("repetitionsMin", repetitionsMin);
        sessionExercise.put("repetitionsMax", repetitionsMax);
        sessionExercise.put("waitMin", waitMin);
        sessionExercise.put("waitMax", waitMax);
        sessionExercise.put("weightMin", weightMin);
        sessionExercise.put("weightMax", weightMax);
        return sessionExercise;
    }

    @Override
    public String toString() {
        return "SessionExercise{" +
                "setsMin=" + setsMin +
                ", repetitionsMin=" + repetitionsMin +
                ", setsMax=" + setsMax +
                ", repetitionsMax=" + repetitionsMax +
                ", waitMin=" + waitMin +
                ", waitMax=" + waitMax +
                ", weightMin=" + weightMin +
                ", weightMax=" + weightMax +
                "} " + super.toString();
    }
}
