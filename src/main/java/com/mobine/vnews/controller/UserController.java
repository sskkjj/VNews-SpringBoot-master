package com.mobine.vnews.controller;

import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public String delete(@RequestParam String username){
        User user=new User(username);
        return userService.delete(user);
    }
    //@RequestMapping(value="/user/{telephone}",method = RequestMethod.GET)
   // public
}
