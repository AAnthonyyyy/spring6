package com.hgm.springiocxml.auto;

import com.hgm.springiocxml.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController controller = context.getBean("userController", UserController.class);
        controller.addUser();
    }
}
