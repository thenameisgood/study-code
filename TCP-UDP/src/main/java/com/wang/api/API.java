package com.wang.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 9:43
 */
public class API {
    public static void main(String[] args) throws UnknownHostException {

        System.out.println(InetAddress.getLocalHost());//DellWFT/10.240.73.62

        InetAddress inetAddresses = InetAddress.getByName("DellWFT");
        System.out.println(inetAddresses);

        InetAddress host = InetAddress.getByName("www.baidu.com");
        System.out.println(host);//www.baidu.com/36.152.44.95

        System.out.println(host.getHostAddress());//36.152.44.95

        System.out.println(host.getHostName());//www.baidu.com

    }
}

