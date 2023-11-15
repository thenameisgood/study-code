package com.wang.create;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main");

//        new CreateThread1().run();
//        new CreateThread1().start();

        new Thread(new CreateThread2()).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main  " + i);
        }
        Thread.sleep(100);

//        Thread.currentThread().join();

        Thread thread = new Thread(new CreateThread2());
//        thread.setPriority(7);
//        thread.setDaemon(true);

    }
}