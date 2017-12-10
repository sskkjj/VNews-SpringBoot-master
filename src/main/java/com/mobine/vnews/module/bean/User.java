package com.mobine.vnews.module.bean;

import org.apache.logging.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * Created by xuantang on 11/27/17.
 */
public class User {

    private String ID;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String birthday;
    private String image;
    private String telephone;
    private String motto;
    private String info;
    public  User(){
    }
    public User(String username, String password, String telephone) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public User(String telephone){
        this.telephone=telephone;
    }
    public void print(){
        System.out.println(this.username);
        System.out.println(this.password);
        System.out.println(this.email);
        System.out.println(this.birthday);
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
