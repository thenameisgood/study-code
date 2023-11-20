package com.wang.containerextensionpoints.beanpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessorBean implements BeanPostProcessor {

    public MyBeanPostProcessorBean() {
        // System.out.println("MyBeanPostProcessorBean的无参构造方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // System.out.println("MyBeanPostProcessorBean的postProcessBeforeInitialization " + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // System.out.println("MyBeanPostProcessorBean的postProcessAfterInitialization " + bean.getClass());
        return bean;
    }
}
