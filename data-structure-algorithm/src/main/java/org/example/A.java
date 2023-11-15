package org.example;

/**
 * @author: ht
 * @date: 2022/10/24 19:06
 */
public abstract class A {

    public A(int a) {
        System.out.println("抽象类A的无参构造方法执行了");
    }

    public void init(){
        System.out.println("抽象类的init方法");
    };
}

