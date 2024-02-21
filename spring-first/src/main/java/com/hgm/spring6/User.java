package com.hgm.spring6;

public class User {

    public User(){
        System.out.println("0.无参数构造");
    }

    public void add() {
        System.out.println("1.xml配置文件创建对象 ");
    }

    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
}
