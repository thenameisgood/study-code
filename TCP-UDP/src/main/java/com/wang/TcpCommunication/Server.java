package com.wang.TcpCommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 9:58
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        byte[] bytes = new byte[10];
        int readLen = 0;

        while ((readLen=inputStream.read(bytes)) != -1){
            System.out.print(new String(bytes, 0, readLen));
        }

        accept.shutdownInput();

        outputStream.write("你好，Client".getBytes());

        accept.shutdownOutput();

        inputStream.close();
        outputStream.close();
        serverSocket.close();
    }
}

