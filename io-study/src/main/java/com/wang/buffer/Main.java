package com.wang.buffer;

import java.nio.IntBuffer;

public class Main {
    public static void main(String[] args) {

        //创建一个缓冲区不能直接new，需要使用静态方法生成
        //1.
//        IntBuffer allocate = IntBuffer.allocate(10);

        //2.
        int[] ints = {1, 2, 3, 4, 5};
        IntBuffer wrap = IntBuffer.wrap(ints);

        wrap.get();
        wrap.get(1);
        wrap.put(1,100);
        wrap.put(new int[]{4,5,6});

        System.out.println(wrap);
    }
}
