package com.wang.TcpFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 10:43
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\mt.md"));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        //回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("server成功接收文件");
        bufferedWriter.flush();
        socket.shutdownOutput();

        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}

