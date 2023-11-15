package com.wang.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < 3; ++i) {
            int rand = new SecureRandom().nextInt(100);
            buffer.put(rand);
        }

        System.out.println("before flip limit " + buffer.limit());
        buffer.flip();
        System.out.println("after flip limit " + buffer.limit());

        while (buffer.hasRemaining()) {
            System.out.println("---------------");
            System.out.println("position " + buffer.position());
            System.out.println("limit " + buffer.limit());
            System.out.println("capacity " + buffer.capacity());
            System.out.println(buffer.get());
        }
        System.out.println("---------------");

        System.out.println("before flip limit " + buffer.limit());
        System.out.println("before flip position " + buffer.position());
        buffer.flip();
        System.out.println("after flip limit " + buffer.limit());
        System.out.println("after flip position " + buffer.position());
    }
}
