package com.wang.TcpCommunication;

import java.io.*;
import java.net.Socket;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 10:26
 */
public class ClientReaderWriter {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        //字节流抓换成字符流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        writer.write("你好，我是Server，这是字符流");
        writer.newLine();//插入一个换行符。表示写入结束  但要求对方使用readLine()来接收
        writer.flush();

        String s = reader.readLine();
        System.out.println(s);

        writer.close();
        reader.close();
        socket.close();
    }
}

