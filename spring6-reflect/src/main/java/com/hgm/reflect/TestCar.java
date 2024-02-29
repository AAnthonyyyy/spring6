package com.hgm.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCar {

    // 1、获取Class对象的三种常用方法
    @Test
    public void test01() throws Exception {
        // (1) 类名.class
        Class<Car> clazz1 = Car.class;

        // (2) 对象.getClass()
        Class<? extends Car> clazz2 = new Car().getClass();

        // (3) Class.forName("全路径")
        Class<?> clazz3 = Class.forName("com.hgm.reflect.Car");


        // 实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }


    // 2、获取构造方法
    @Test
    public void test02() throws Exception {
        Class<Car> clazz = Car.class;
        // 获取所有的构造函数
        /**
         * 注意：
         * getConstructors()：只获取所有的public构造方法，如果是private是获取不到的
         * getDeclaredConstructors()：是可以获取所有的构造方法，无论什么类型
         */
//        Constructor[] constructors = clazz.getConstructors();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造方法名称：" + c.getName() + " 构造参数个数：" + c.getParameterCount());
        }


        // 指定有参数构造方法创建对象
        // public 类型
//        Constructor<Car> c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car = c1.newInstance("凌志", 20, "黑色");
//        System.out.println(car);

        // private 类型
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);// 设置可访问，否则访问不了private的东西
        Car car2 = c2.newInstance("保时捷", 20, "黑色");
        System.out.println(car2);
    }


    // 3、获取属性
    @Test
    public void test03() throws Exception {
        Class<Car> clazz = Car.class;
        Car car = clazz.getDeclaredConstructor().newInstance();

        // 获取所有public属性
//        Field[] fields = clazz.getFields();
        // 获取所有属性（包括私有的）
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "宝马");
            }
            System.out.println(field.getName());
            System.out.println(car);
        }
    }


    // 4、获取方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();

        // public 方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
//            System.out.println(m1.getName());
            // 执行某个方法
            if (m1.getName().equals("toString")) {
                String str = (String) m1.invoke(car);
                System.out.println("toString方法执行了" + str);
            }
        }

        // private 方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m1 : methodsAll) {
            // 执行某个方法
            if (m1.getName().equals("run")) {
                m1.setAccessible(true);
                m1.invoke(car);
            }
        }
    }

}
