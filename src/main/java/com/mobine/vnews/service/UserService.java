package com.mobine.vnews.service;


import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.User;

import com.mobine.vnews.util.IdUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Create by xuantang
 * @date on 12/9/17
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
            code = 400;
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
            code=400;
            response.setContent("");
            message="login fail";
        }
        response.setCode(code);
        response.setMessage(message);
        log.info(response.toString());
        return response;
    }
    public String delete(User user){
        String message="success";
        try{
            int result=userMapper.removeUserByUsername(user);
            log.info(result);
        }catch (Exception e){
            message="fail";
        }
        return  message;
    }
}
