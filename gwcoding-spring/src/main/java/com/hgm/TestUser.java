package com.hgm;

import com.hgm.bean.AnnotationApplicationContext;
import com.hgm.bean.ApplicationContext;
import com.hgm.service.UserService;

/**
 * 手写Spring框架，完成Bean对象创建和属性注入
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.hgm");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
