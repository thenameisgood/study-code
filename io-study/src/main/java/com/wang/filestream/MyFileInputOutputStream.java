package com.wang.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileInputOutputStream {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\37172\\Desktop\\test.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\37172\\Desktop\\test2.txt")) {
            byte[] bytes = new byte[1];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
