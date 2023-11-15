package com.wang.convert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyOutputStreamWriter {
    public static void main(String[] args) {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("test.txt"))) {
            outputStreamWriter.write("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
