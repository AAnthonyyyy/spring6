package com.hgm.spring6.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(7,7);
    }
}
