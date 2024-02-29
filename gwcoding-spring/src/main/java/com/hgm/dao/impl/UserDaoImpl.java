package com.hgm.dao.impl;

import com.hgm.anno.Bean;
import com.hgm.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("Dao add...");
    }
}
