package com.wang.filestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputStream {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\37172\\Desktop\\test.txt", true)) {
            fileOutputStream.write('c');
            fileOutputStream.write("yyyyyyy".getBytes());
            fileOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
