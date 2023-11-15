package com.wang.spring.complexObjects;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
    //复杂对象的创建方式
    @Override
    public Connection getObject() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    }

    //复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    //指定对象模式
    @Override
    public boolean isSingleton() {
        return false;
    }
}

