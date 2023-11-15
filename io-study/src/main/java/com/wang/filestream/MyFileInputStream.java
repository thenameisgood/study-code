package com.wang.filestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\37172\\Desktop\\test.txt")) {
            int read1 = fileInputStream.read();
            System.out.println((char) read1);

//            fileInputStream.skip(1L);
//            fileInputStream.reset();
            byte[] bytes = new byte[fileInputStream.available()];
            while (fileInputStream.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
