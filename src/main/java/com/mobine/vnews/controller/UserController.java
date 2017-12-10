package com.mobine.vnews.controller;

import com.alibaba.fastjson.JSON;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.service.UserService;
import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.logging.log4j.core.config.LoggerConfig.ROOT;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

@RestController
@RequestMapping({"/vnews"})
public class UserController {


    @Autowired
    UserService userService;
    @RequestMapping(value ="/hello",method = RequestMethod.GET)
    public String hello(){
        return "helloworld";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BasicResponse<String> register(@RequestParam String username, @RequestParam String password,
                                  @RequestParam String telephone){
        User user = new User(username, password, telephone);
        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BasicResponse<String> login(@RequestParam String username, @RequestParam String password){
        User user=new User(username,password);
        return userService.login(user);
    }
    @RequestMapping(value="/user/tel/{telephone}",method=RequestMethod.GET)
    public BasicResponse<String> checkPhone(@PathVariable("telephone") String telephone){
        User user=new User(telephone);
        return userService.checkPhone(user);
    }
    @RequestMapping(value="/user/{username}",method = RequestMethod.PUT)
    public BasicResponse<String>updateUser(@PathVariable("username")String username, @RequestBody User object){
        object.setUsername(username);
        object.print();
        return userService.updateUser(object);
    }
    @RequestMapping(value="/user/{username}/image",method=RequestMethod.POST)
    public BasicResponse<String>updatePhoto(@PathVariable("username")String username, @RequestParam("photo")MultipartFile file){
        User user=new User();
        user.setUsername(username);
        return userService.updatePhoto(user,file);
    }
    @RequestMapping(value="/user/{username}",method=RequestMethod.GET)
    public BasicResponse<User>getUser(@PathVariable("username") String username){
        User user=new User();
        user.setUsername(username);
        return userService.getUser(user);
    }
    //@RequestMapping(value="/user/{telephone}",method = RequestMethod.GET)
   // public
}
