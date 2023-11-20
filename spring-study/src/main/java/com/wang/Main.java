package com.wang;

import com.wang.service.impl.PetServiceImpl;
import com.wang.service.impl.PetStoreServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.function.Consumer;

/**
 * 基于XML文件的容器配置
 *  **/
public class Main {

    public static void main(String[] args) {
        // ApplicationContext是BeanFactory的子接口  ApplicationContext extends [ListableBeanFactory extends [BeanFactory]]
        
        // 创建和配置两种方式都可以  create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        
        // 更灵活的变体
        // GenericApplicationContext context = new GenericApplicationContext();
        // new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
        // context.refresh();

        // 除了让spring创建Bean外，spring还支持注册外部的Bean
        // ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // void registerSingleton(String beanName, Object singletonObject);

        // 检索Bean实例  retrieve configured instance
        // PetStoreServiceImpl service = context.getBean("petStoreService", PetStoreServiceImpl.class);
        // 使用配置Bean实例 use configured instance
        // List<String> userList = service.getUsernameList();
        // userList.forEach(s -> System.out.println(s));

        // PetServiceImpl petServiceImpl = context.getBean("petService", PetServiceImpl.class);
        // System.out.println("petServiceImpl: " + petServiceImpl);
        
        // context.registerShutdownHook();
    }
}