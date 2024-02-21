package com.hgm.springiocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取bean的几种方式
        // 1、根据id获取
        User user = (User) context.getBean("user");
        System.out.println("根据id获取bean：" + user);

        // 2、根据类型获取
        User user2 = context.getBean(User.class);
        System.out.println("根据类型获取bean：" + user2);


        // 3、根据结合id和类型获取
        User user3 = context.getBean("user", User.class);
        System.out.println("根据结合id和类型获取bean：" + user3);
    }
}
