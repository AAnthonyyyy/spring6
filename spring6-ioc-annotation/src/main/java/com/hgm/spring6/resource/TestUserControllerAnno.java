package com.hgm.spring6.resource;

import com.hgm.spring6.config.SpringConfig;
import com.hgm.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserControllerAnno {

    public static void main(String[] args) {
        // 不需要加载spring配置文件了，直接加载配置类
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.run();
    }
}
