package com.example.kanban;

public class NotificationModel {
    private int id;
    private String text;
    private String time;
    private String date;

    public NotificationModel(int id, String text, String time, String date) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
