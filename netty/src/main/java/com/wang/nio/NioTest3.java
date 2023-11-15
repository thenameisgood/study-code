package com.wang.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] msg = "hello word !".getBytes();

        for (int i = 0; i < msg.length; i++) {
            byteBuffer.put(msg[i]);
        }

        byteBuffer.flip();
        channel.write(byteBuffer);

        fileOutputStream.close();
    }
}
