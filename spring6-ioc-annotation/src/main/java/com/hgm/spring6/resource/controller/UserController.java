package com.hgm.spring6.resource.controller;

import com.hgm.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller(value = "myUserController")
public class UserController {

//    // 1、根据名称注入
//    @Resource(name = "myUserService")
//    private UserService userService;

//    // 2、根据属性名注入
//    @Resource
//    private UserService myUserService;

    // 3、根据类型注入
    @Resource
    private UserService userService;

    public void run() {
        System.out.println("UserController：执行结束..");
        userService.run();
    }

}
