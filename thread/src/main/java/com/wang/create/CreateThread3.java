package com.wang.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CreateThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("实现Callable接口方式");
        // ... 具体业务逻辑
        return "返回值";
    }

    public static void main(String[] args) {
        // 创建Callable实现类对象
        CreateThread3 callable = new CreateThread3();
        // 将callable作为参数创建FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 将futureTask作为参数创建线程
        Thread thread = new Thread(futureTask);
        thread.start(); // 启动线程
        try {
            // 获取线程执行后的返回值
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
