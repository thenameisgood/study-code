package com.wang.spring.complexObjects;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class CalendarFactoryBean implements FactoryBean<Calendar> {

    //复杂对象的创建方式
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();
    }

    //复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    //指定对象模式
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

