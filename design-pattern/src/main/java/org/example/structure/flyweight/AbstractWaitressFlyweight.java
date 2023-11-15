package org.example.structure.flyweight;

public abstract class AbstractWaitressFlyweight {

    boolean canService = true;

    //正在服务  享元的不可共享竖向留给外部进行改变的接口
    abstract void service();

    //服务完成  享元的不可共享竖向留给外部进行改变的接口
    abstract void end();
}
