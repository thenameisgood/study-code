package com.wang.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class BIO {
    public static void main(String[] args) throws IOException {
        //实际上是开启了一个线程
        ServerSocket server = new ServerSocket(9090, 20);
        System.out.println("step1: new ServerSocket(9090, 20)");
        while (true) {
            Socket client = server.accept();
            System.out.println("step2: client\t"+client.getPort());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream in = null;

                    try {
                        in = client.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true){
                            //阻塞
                            String data = reader.readLine();
                            if (data != null){
                                System.out.println(data);
                            }else {
                                client.close();
                                break;
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
