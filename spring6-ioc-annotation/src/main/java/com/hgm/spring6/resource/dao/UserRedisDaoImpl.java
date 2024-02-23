package com.hgm.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("UserRedisDao：执行结束...");
    }
}
