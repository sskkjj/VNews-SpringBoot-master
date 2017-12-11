package com.mobine.vnews.controller;
import com.alibaba.fastjson.JSON;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import com.mobine.vnews.service.NewsService;
import com.mobine.vnews.service.PreferenceService;
import com.mobine.vnews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("vnews/user/{user_id}/preference")
public class PreferenceController {
   @Autowired
    PreferenceService preferenceService;
    @RequestMapping(value = "",method = RequestMethod.POST)
    public BasicResponse<String> addPreference(@PathVariable("user_id") String user_id,@RequestBody String json){
        userPreference user_preference=new userPreference();
        user_preference.setUserID(user_id);
        return preferenceService.addPreference(json,user_preference);
    }
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public BasicResponse<String> modifyPreference(@PathVariable("user_id") String  user_id,@RequestBody String json){
        userPreference user_preference=new userPreference();
        user_preference.setUserID(user_id);
        return preferenceService.modifyPreference(json,user_preference);
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BasicResponse<List<userPreference>> getPreference(@PathVariable("user_id") String  user_id){
        userPreference user_preference=new userPreference();
        user_preference.setUserID(user_id);
        return preferenceService.getPreference(user_preference);
    }
}
