package com.hgm.spring6.autowrite.controller;

import com.hgm.spring6.autowrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 注入Service
    // 方式一：属性注入
//    @Autowired// 根据类型找到对应对象，完成注入
//    private UserService userService;

    // 方式二：set方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 方式三：构造器注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 方式四：形参上注入
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    // 方式五：只有一个有参构造器，无注解
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 方式六：搭配@AutoWrite和@Qualifier(value = "...")注解注入
//    @Autowired
//    @Qualifier(value = "userInfoService")
//    private UserService userService;

    public void run() {
        System.out.println("UserController：执行结束..");
        userService.run();
    }

}
