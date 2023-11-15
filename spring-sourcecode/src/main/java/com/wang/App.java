package com.wang;

import com.wang.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");

        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
        // BeanFactory
        // BeanPostProcessor         
        // BeanFactoryPostProcessor
    }
}
