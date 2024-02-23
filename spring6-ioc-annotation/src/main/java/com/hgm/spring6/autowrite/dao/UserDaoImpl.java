package com.hgm.spring6.autowrite.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("UserDao：执行结束...");
    }
}
