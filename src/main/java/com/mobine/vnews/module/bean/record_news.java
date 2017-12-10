package com.mobine.vnews.module.bean;

public class record_news {
    String userID;
    int newsID;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public void setStmap(String stmap) {
        this.stmap = stmap;
    }

    public String getUserID() {

        return userID;
    }

    public int getNewsID() {
        return newsID;
    }

    public String getStmap() {
        return stmap;
    }

    String stmap;
}
