package com.wang.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class NioClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if (client.isConnectionPending()) {
                            try {
                                client.finishConnect();
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                buffer.put((LocalDateTime.now() + "连接成功").getBytes());
                                buffer.flip();
                                client.write(buffer);

                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(() -> {
                                    while (true) {
                                        try {
                                            buffer.clear();
                                            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                                            String s = bufferedReader.readLine();
                                            buffer.put(s.getBytes());
                                            buffer.flip();
                                            client.write(buffer);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            client.register(selector, SelectionKey.OP_READ);
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }
                    } else if (selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        try {
                            int count = client.read(readBuffer);
                            if (count > 0) {
                                String s = new String(readBuffer.array(), 0, count);
                                System.out.println(s);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                selectionKeys.clear();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
