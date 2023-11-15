package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:53
 */
public class XiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void shutdown() {
        System.out.println("小米路由器关机");
    }

    @Override
    public void wifi() {
        System.out.println("小米路由器打开WiFi");
    }

    @Override
    public void set() {
        System.out.println("小米路由器设置");
    }
}

