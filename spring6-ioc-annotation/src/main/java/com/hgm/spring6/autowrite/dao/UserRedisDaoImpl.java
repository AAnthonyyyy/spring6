package com.hgm.spring6.autowrite.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("UserRedisDao：执行结束...");
    }
}
