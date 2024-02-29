package com.hgm.service.impl;

import com.hgm.anno.Bean;
import com.hgm.anno.Di;
import com.hgm.dao.UserDao;
import com.hgm.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("Service add....");
        // 调用dao方法
        userDao.add();
    }
}
