package com.mobine.vnews.module.bean;

public class Comment {
    int ID;
    String fromID;
    String toID;
    String content;
    String timestamp;
    String username;
    int newsID;
    int floor;
    public void setUsername(String username){this.username=username;}

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getID() {

        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getFromID() {
        return fromID;
    }

    public String getToID() {
        return toID;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getNewsID() {
        return newsID;
    }

    public int getFloor() {
        return floor;
    }
}
