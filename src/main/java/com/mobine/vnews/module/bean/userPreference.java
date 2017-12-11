package com.mobine.vnews.module.bean;

public class userPreference {
    String userID;
    int typeID;
    int preference;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    public String getUserID() {

        return userID;
    }

    public int getTypeID() {
        return typeID;
    }

    public int getPreference() {
        return preference;
    }
}
