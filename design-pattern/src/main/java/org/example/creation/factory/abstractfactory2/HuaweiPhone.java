package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:52
 */
public class HuaweiPhone implements IPhoneProduct {
    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为手机关机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendMsg() {
        System.out.println("华为手机发信息");
    }
}

