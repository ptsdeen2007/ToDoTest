package com.test.myapplication;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String title;
    private String description;
    private Boolean completed;

    public Task(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
