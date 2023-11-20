package com.wang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
 *  基于Java的容器配置   Java-based Container Configuration
 *  **/
public class MainAnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ctx);

        System.out.println(ctx.getBean("petService"));
    }
}
