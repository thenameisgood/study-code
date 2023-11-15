package com.wang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class NIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        //不阻塞
        ss.configureBlocking(false);
        ss.setOption(StandardSocketOptions.TCP_NODELAY, false);

//        StandardSocketOptions.SO_KEEPALIVE
//        StandardSocketOptions.SO_LINGER
//        StandardSocketOptions.SO_RCVBUF
//        StandardSocketOptions.SO_SNDBUF
//        StandardSocketOptions.SO_REUSEADDR

        while (true) {
//            Thread.sleep(1000);
            SocketChannel client = ss.accept();     // -1 null

            if (client == null) {
//                System.out.println("null.....");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client.port:" + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

            //遍历已连接进来的客户端
            for (SocketChannel c : clients) {
                int num = c.read(buffer);   // >0  0  -1
                if (num > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    buffer.get(bytes);

                    String s = new String(bytes);
                    System.out.println(c.socket().getPort() + " : " + s);
                }
            }

        }
    }
}
