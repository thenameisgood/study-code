package com.wang.spring;

import com.wang.spring.domain.entity.User;
import com.wang.spring.service.AOPService;
import com.wang.spring.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //启动工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");

        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        List<User> users = userService.findUsers();
        users.forEach(user -> System.out.println(user));

        Arrays.stream(userService.getArrayMy()).forEach(s -> System.out.println(s));

        userService.getListMy().forEach(l -> System.out.println(l));

        userService.getPropertiesMy().forEach((o, o2) -> System.out.println("key:"+o+"  value:"+o2));
//        复杂对象
        Calendar calendar = (Calendar) context.getBean("calendarFactoryBean");
        System.out.println(calendar);


//        AOP
        AOPService aOPService = (AOPService) context.getBean("aOPService");
        aOPService.target();
        //关闭工厂
        context.close();
    }
}

