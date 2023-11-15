package com.wang.create;

public class CreateThread1 extends Thread{
    //Thread 代理
    @Override
    public void run() {
        System.out.println("CreateThread1A#run");
        for (int i = 0; i < 1000; i++) {
            System.out.println("CreateThread1A#run  "+i);
        }
    }
}
