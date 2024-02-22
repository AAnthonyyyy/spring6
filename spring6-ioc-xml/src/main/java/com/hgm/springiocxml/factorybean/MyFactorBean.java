package com.hgm.springiocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactorBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
