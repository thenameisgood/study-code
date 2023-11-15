package org.example;

/**
 * @author: ht
 * @date: 2022/10/24 19:07
 */
public class B extends A{
    public B() {
        super(1);
        System.out.println("B的无参构造方法执行了");
    }

    @Override
    public void init() {
        System.out.println("0u98");
    }
}


