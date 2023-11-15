package com.wang.TcpFile;

import java.io.*;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 10:43
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);

        //读取磁盘文件 E:\MATLAB笔记.md
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\MATLAB笔记.md"));
        //文件对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedInputStream.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);
        socket.shutdownInput();

        bufferedReader.close();
        bufferedOutputStream.close();
        socket.close();
    }
}

