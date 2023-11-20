package com.wang.containerextensionpoints.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new MyFactoryBeanInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBeanInstance.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
