package com.wang.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        FileLock fileLock = channel.lock(3, 6, true);
        System.out.println(fileLock.isValid());
        System.out.println(fileLock.isShared());
        fileLock.release();

        randomAccessFile.close();
    }
}
