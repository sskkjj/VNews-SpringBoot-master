package com.mobine.vnews.service;


import com.alibaba.fastjson.JSONObject;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.User;

import com.mobine.vnews.util.IdUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.logging.log4j.core.config.LoggerConfig.ROOT;

/**
 * @author Create by Kevin
 * @date on 12/10
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 日志输出
     */
    private static Logger log = LogManager.getLogger(UserService.class);

    public BasicResponse<String> register(User user) {
        BasicResponse<String> response = new BasicResponse<>();
        int code = 200;
        String message = "success";
        try {
            // add user
            user.setID(IdUtils.getUUID());
            System.out.println(user.toString());
            int res = userMapper.addUser(user);
            log.info(res);
        } catch (Exception e) {
            code = 500;
            message = e.getMessage();
        }
        // set values
        response.setCode(code);
        response.setMessage(message);
        // log
        log.info(response.toString());
        return response;
    }
    public BasicResponse<String> login(User user){
        BasicResponse<String >response=new BasicResponse<>();
        int code=200;
        String message="login success";
        try{
            System.out.println(user.toString());
            User res=userMapper.findUserByUsername(user);
            response.setContent("");
            log.info(res);
        }catch (Exception e){
            code=500;
            response.setContent("");
            message="login fail";
        }
        response.setCode(code);
        response.setMessage(message);
        log.info(response.toString());
        return response;
    }
    public BasicResponse<String> checkPhone(User user){
        BasicResponse<String>response=new BasicResponse<>();
        int code=400;
        String message="telephone has been used";
        response.setContent("");
        try{
            User res=userMapper.checkPhone(user);
            if(res==null){
                code =200;
                message="telephone available";
            }
        }catch (Exception e){
            message=e.getMessage();
            code=500;
        }
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
    public BasicResponse<String> updateUser(User user){
        BasicResponse<String>response=new BasicResponse<>();
        int code=200;
        String message="update success";
        response.setContent("");
        try{
            int res=userMapper.updateUser(user);
            if(res==0){
                code=400;
                message="update fail";
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<String>updatePhoto(User user, MultipartFile file){
        BasicResponse<String>response=new BasicResponse<>();
        int code=200;
        String message="update photo success";
        response.setContent("");
        try{
            String filename=file.getOriginalFilename();
            byte[]bytes=file.getBytes();
            BufferedOutputStream buffStream=new BufferedOutputStream(new FileOutputStream(new File("F:/cp/"+filename)));
            buffStream.write(bytes);
            buffStream.close();
            user.setImage("F:/cp/"+filename);
            int res=userMapper.updatePhoto(user);
        }catch (IOException|RuntimeException e ){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
    public BasicResponse<User> getUser(User user){
        BasicResponse<User>response=new BasicResponse<>();
        int code=200;
        String message="get information success";
        response.setContent(new User());
        try{
            User myUser=userMapper.getUser(user);
            response.setContent(myUser);
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
}
