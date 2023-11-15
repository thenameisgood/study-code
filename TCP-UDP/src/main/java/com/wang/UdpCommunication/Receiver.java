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
public class Receiver {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);

        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);


        byte[] data2 = "我是返回的数据".getBytes();
        DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length, InetAddress.getByName("127.0.0.1"), 9998);

        datagramSocket.send(datagramPacket2);


        datagramSocket.close();
    }
}

