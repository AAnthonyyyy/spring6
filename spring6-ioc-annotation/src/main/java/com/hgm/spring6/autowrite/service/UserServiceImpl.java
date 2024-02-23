package com.hgm.spring6.autowrite.service;

import com.hgm.spring6.autowrite.dao.UserDao;
import com.hgm.spring6.autowrite.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    // 注入Service
//    @Autowired
//    private UserDao userDao;

//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;


    @Override
    public void run() {
        System.out.println("UserService：执行结束...");
        userDao.run();
    }
}
