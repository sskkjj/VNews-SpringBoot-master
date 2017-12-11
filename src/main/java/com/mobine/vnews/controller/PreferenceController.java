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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("user/{user_id}/preference")
public class PreferenceController {
   @Autowired
    PreferenceService preferenceService;
    
}
