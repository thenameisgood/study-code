package com.wang.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test2 {
    public static void main(String[] args) {
        // Interface1Test1 i = new Interface1Test1() {
        //     @Override
        //     public void method1() {
        //         System.out.println("method1");
        //     }
        // };

        Interface1Test1 i1 = () -> System.out.println("method1");
        i1.method1();
        System.out.println(i1.getClass().getInterfaces()[0]);

        Interface2Test2 i2 = () -> System.out.println("method2");
        i2.method2();
        System.out.println(i2.getClass().getInterfaces()[0]);

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 新线程启动")).start();

        // 

        List<String> list = Arrays.asList("hello", "word", "h", "w");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);
        
        list.stream().map((Function<String, Object>) String::toUpperCase).forEach(System.out::println);
    }
}

@FunctionalInterface
interface Interface1Test1 {
    void method1();
}

@FunctionalInterface
interface Interface2Test2 {
    void method2();
}