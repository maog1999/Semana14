package com.example.practicasemana14;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private String id;
    private String tittle;
    private String description;
    private long date;
    private boolean completed;

    public Task(String id, String tittle, String description){
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.completed = false;
        this.date = new Date().getTime();
    }

    public String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date();
        date.setTime(this.date);
        return sdf.format(date);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
