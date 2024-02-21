package com.hgm.springiocxml.bean;

public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("person run...");
    }
}
