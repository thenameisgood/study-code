package com.wang.UdpCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 11:37
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        byte[] data = "我是sender".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
        datagramSocket.send(datagramPacket);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(buffer,buffer.length);

        datagramSocket.receive(datagramPacket2);

        int length = datagramPacket2.getLength();
        byte[] data2 = datagramPacket2.getData();
        String s = new String(data2, 0, length);
        System.out.println(s);

        datagramSocket.close();
    }
}
