package com.hgm.springiocxml.bean;

public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("user run...");
    }
}
