package com.hgm.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "myUserDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("UserDao：执行结束...");
    }
}
