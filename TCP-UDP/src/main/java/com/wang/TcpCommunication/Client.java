package com.wang.TcpCommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 9:58
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        outputStream.write("我是client".getBytes());

        socket.shutdownOutput();

        byte[] bytes = new byte[10];
        int readLen = 0;
        while ((readLen=inputStream.read(bytes)) != -1){
            System.out.print(new String(bytes, 0, readLen));
        }

        socket.shutdownInput();

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}

