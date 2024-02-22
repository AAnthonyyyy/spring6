package com.hgm.springiocxml.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6、bean对象创建完成了");
        context.close();// 模拟销毁bean对象
    }
}
