package org.example.structure.decorator;

/**
 * 抖音直播抽象装饰器  可以使用抽象层
 * */
public interface TicTokDecorator extends StarTicTok{

    //美颜装饰器
    void enableMeiyan();
}
