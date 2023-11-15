package com.wang.defaultmethod;

/**
 * 实现类的优先级要比接口优先级高
 * */
public class MyClass extends MyInterface1Impl implements MyInterface1, MyInterface2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    // @Override
    // public void myMethod() {
    //     MyInterface1.super.myMethod();
    //     MyInterface2.super.myMethod();
    //     System.out.println("MyClass");
    // }
}
