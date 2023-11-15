package com.wang.createbean;

public class ByStaticFactory {
    private static ByStaticFactory byStaticFactory = new ByStaticFactory();

    private ByStaticFactory() {
    }

    public static ByStaticFactory createInstance() {
        return byStaticFactory;
    }
}
