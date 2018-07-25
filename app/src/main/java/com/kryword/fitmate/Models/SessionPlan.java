package com.kryword.fitmate.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SessionPlan {
    private int id;
    private String title;
    private String description;
    private List<SessionExercise> exercises;

    public SessionPlan(){
    }

    public SessionPlan(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        exercises = new ArrayList<>();
    }

    public SessionPlan(int id, String title, String description, List<SessionExercise> exercises) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionExercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<SessionExercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "SessionPlan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", exercises=" + exercises +
                '}';
    }

    public JSONObject toJson() throws JSONException {
        JSONObject sessionPlan = new JSONObject();
        sessionPlan.put("id", id);
        sessionPlan.put("title", title);
        sessionPlan.put("description", description);
        JSONArray jsonExercises = new JSONArray();
        for (SessionExercise sessionExercise :
                exercises) {
            jsonExercises.put(sessionExercise.toJSON());
        }
        sessionPlan.put("exercises", jsonExercises);
        return sessionPlan;
    }

    public void addExercise(SessionExercise exercise){
        exercises.add(exercise);
    }

    public void removeExercise(SessionExercise exercise){
        exercises.remove(exercise);
    }
}
