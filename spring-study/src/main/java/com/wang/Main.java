package com.wang;

import com.wang.service.impl.PetStoreServiceImpl;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        // ApplicationContext是BeanFactory的子接口    ApplicationContext extendsListableBeanFactory extends BeanFactory
        // create and configure beans  两种方式都可以
        // ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        // 更灵活的变体
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
        context.refresh();

        /* 除了让spring创建Bean外，spring还支持注册外部的Bean
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.registerSingleton();*/
        
        // retrieve configured instance
        PetStoreServiceImpl service = context.getBean("petStoreService", PetStoreServiceImpl.class);

        // use configured instance
        List<String> userList = service.getUsernameList();

        userList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // System.out.println(context.getBean("demoBeanInstance"));
        
        context.registerShutdownHook();
    }
}