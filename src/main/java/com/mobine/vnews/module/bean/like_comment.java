package com.mobine.vnews.module.bean;

public class like_comment {
    String user_id;
    int comment_id;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setConment_id(int comment_id) {
        this.comment_id=comment_id;
    }

    public String getUser_id() {

        return user_id;
    }

    public int getComment_id() {
        return comment_id;
    }
}
