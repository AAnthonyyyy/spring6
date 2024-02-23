package com.hgm.spring6.resource.service;

import com.hgm.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "myUserService")// 定义名称与注入保持一致
public class UserServiceImpl implements UserService {

    // 如果不指定名称，那么会根据属性名进行注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void run() {
        System.out.println("UserService：执行结束...");
        myUserDao.run();
    }
}
