package com.wang.create;

public class CreateThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("CreadeThread2#run");
        for (int i = 0; i < 1000; i++) {
            System.out.println("CreadeThread2  "+i);
        }
    }
}
