package com.wang;

public class MyLock {
    public static void main(String[] args) {

        //死锁
        new Thread(() -> A.method(), "Thread-A").start();
        new Thread(() -> B.method(), "Thread-B").start();
    }
}

class A {
    public static synchronized void method() {
        System.out.println("method from A");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
