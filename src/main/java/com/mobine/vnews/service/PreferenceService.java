package com.mobine.vnews.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mobine.vnews.mapper.CommentMapper;
import com.mobine.vnews.mapper.PreferenceMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PreferenceService {
    @Autowired
    PreferenceMapper preferenceMapper;
    public BasicResponse<String> addPreference(String json,userPreference user_preference){
        BasicResponse<String> response=new BasicResponse<>();
        int code=200;
        String message="add preference success";
        try{
            LinkedHashMap<String, String> jsonMap = JSON.parseObject(json, new TypeReference<LinkedHashMap<String, String>>() {
            });
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                user_preference.setTypeID(Integer.valueOf(entry.getKey()));
                user_preference.setPreference(Integer.valueOf(entry.getValue()));
                preferenceMapper.addPreference(user_preference);
            }
        }catch ( Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<String> modifyPreference(String json,userPreference user_preference){
        BasicResponse<String> response=new BasicResponse<>();
        int code=200;
        String message="modify preference success";
        try{
            int deleteRes=preferenceMapper.deletePreference(user_preference);
            LinkedHashMap<String, String> jsonMap = JSON.parseObject(json, new TypeReference<LinkedHashMap<String, String>>() {
            });
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                user_preference.setTypeID(Integer.valueOf(entry.getKey()));
                user_preference.setPreference(Integer.valueOf(entry.getValue()));
                preferenceMapper.addPreference(user_preference);
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<List<userPreference>> getPreference(userPreference user_preference){
        BasicResponse<List<userPreference>> response=new BasicResponse<>();
        int code=200;
        String message="get preference success";
        try{
            ArrayList<userPreference> arrayList=new ArrayList<>();
            arrayList=(ArrayList<userPreference>) preferenceMapper.getPreference(user_preference);
            response.setContent(arrayList);
        }catch ( Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
}
