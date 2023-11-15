package com.wang.filereaderwriter;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("C:\\Users\\37172\\Desktop\\test.txt")) {
            int read = fileReader.read();
            System.out.println((char) read);
            String encoding = fileReader.getEncoding();
            System.out.println(encoding);

            int read2 = fileReader.read();
            System.out.println((char) read2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
