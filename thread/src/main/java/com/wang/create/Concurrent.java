package com.wang.create;

public class Concurrent implements Runnable{

    private int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum+"票");
            ticketNum--;
        }
    }

    public static void main(String[] args) {

        Concurrent concurrent = new Concurrent();

        //多线程操作同一个资源  会出现并发问题
        new Thread(concurrent,"老鼠").start();
        new Thread(concurrent,"大象").start();
        new Thread(concurrent,"黄牛").start();
    }
}
