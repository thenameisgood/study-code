package com.wang.test;

public class test1 {
    public static void main(String[] args) {
        String hello = new String("hello word!");
        byte[] byteArray = hello.getBytes();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.println(byteArray[i]);
        }
    }
}
