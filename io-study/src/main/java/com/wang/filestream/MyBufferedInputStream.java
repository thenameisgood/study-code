package com.wang.filestream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyBufferedInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\37172\\Desktop\\test.txt"))) {
            bufferedInputStream.mark(0);

            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());

            bufferedInputStream.reset();

            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
