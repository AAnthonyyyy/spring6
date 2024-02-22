package com.hgm.springiocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-list.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }
}
