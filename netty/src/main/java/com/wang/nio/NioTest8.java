package com.wang.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        // ByteBuffer wrap = ByteBuffer.wrap(new byte[512]);
        // ByteBuffer buffer = ByteBuffer.allocate(512);
        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

        while (true) {
            buffer.clear(); // 如果注释掉该行会怎么样
            int read = inputChannel.read(buffer);
            if (-1 == read) break;

            buffer.flip();  // 如果注释掉该行会怎么样
            outputChannel.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
