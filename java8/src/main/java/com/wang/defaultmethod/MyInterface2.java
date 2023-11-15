package com.wang.defaultmethod;

public interface MyInterface2 {
    default void myMethod() {
        System.out.println("默认方法，来自于MyInterface2");
    }
}
