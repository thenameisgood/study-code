package com.wang.TcpCommunication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 10:26
 */
public class ServerReaderWriter {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String s = reader.readLine();
        System.out.println(s);

        writer.write("我是Client，字符流");
        writer.newLine();
        writer.flush();

        writer.close();
        reader.close();
        accept.close();
        serverSocket.close();
    }
}

