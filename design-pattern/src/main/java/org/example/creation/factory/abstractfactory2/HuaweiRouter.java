package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:54
 */
public class HuaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为路由器关机");
    }

    @Override
    public void wifi() {
        System.out.println("华为路由器打开WiFi");
    }

    @Override
    public void set() {
        System.out.println("华为路由器设置");
    }
}

