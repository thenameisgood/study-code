package com.wang.springMybatis;

import com.wang.springMybatis.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringMybatis {
    public static void main(String[] args) {
        //启动工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SM/spring-mybatis.xml");

        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.selectAllUser().forEach(s -> System.out.println(s));

        //关闭工厂
        context.close();
    }
}

