package com.wang.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class OldIoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8889);

        String fileName = "";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        DataOutputStream dataOutStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[1024];
        long readCount = 0;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = fileInputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutStream.write(buffer);
        }

        System.out.println("发送总字节数 ：" + total + " 总耗时：" + (System.currentTimeMillis() - startTime));

        dataOutStream.close();
        socket.close();
        fileInputStream.close();
    }
}
