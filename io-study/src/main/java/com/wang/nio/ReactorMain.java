package com.wang.nio;

import java.io.IOException;

public class ReactorMain {
    public static void main(String[] args) {
        //创建Reactor对象，启动，完事
        try (Reactor reactor = new Reactor()) {
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

