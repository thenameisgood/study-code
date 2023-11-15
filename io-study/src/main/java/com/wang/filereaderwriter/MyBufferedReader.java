package com.wang.filereaderwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReader {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\37172\\Desktop\\test.txt"))) {
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
