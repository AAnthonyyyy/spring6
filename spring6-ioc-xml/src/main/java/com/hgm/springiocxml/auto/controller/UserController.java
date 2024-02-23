package com.hgm.springiocxml.auto.controller;

import com.hgm.springiocxml.auto.service.UserService;

public class UserController {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller方法执行了....");

        // 调用service方法
        userService.addUserService();
    }
}
