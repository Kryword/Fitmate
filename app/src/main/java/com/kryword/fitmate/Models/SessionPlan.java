package com.kryword.fitmate.Models;

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
}
