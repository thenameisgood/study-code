package com.wang.functionalInterface;

@FunctionalInterface
interface MyInterfaceTest1 {
    public abstract void test();

    // String myString();

    String toString();
}

public class Test1 {

    public void myTest(MyInterfaceTest1 myInterface) {
        myInterface.test();
    }

    public static void main(String[] args) {
        Test1 test = new Test1();

        // test.myTest(new MyInterface() {
        //     @Override
        //     public void test() {
        //         System.out.println("test");
        //     }
        // });
        test.myTest(() -> System.out.println("test"));


        System.out.println("------------");
        MyInterfaceTest1 myInterface = () -> System.out.println("test");

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
    }
}