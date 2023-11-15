package org.example.structure.flyweight;

import java.util.Set;

/**
 * 享元模式：运用共享技术有效地支持大量细粒度对象的复用。系统只使用少量的对象，而这些对象都很相似，状态变化很小，可以实现对象的多次服用。
 * 在享元模式中，可以共享的相同内容称为内部状态，而那些需要外部环境来设置的不能共享的内容称为外部状态，由于区分了内部状态和外部状态，因
 * 此可以通过设置不同的外部状态使得相同的对象可以具有一些不同的特征，而相同的内部状态是可以共享的
 * IntrinsicState    Extrinsic State
 *
 * 在享元模式中通常会出现工厂模式，需要创建一个享元工厂来负责维护一个享元池(Flyweight Pool)，用于存储具有相同内部状态的享元对象
 *
 * 享元模式的角色：
 * Flyweight：享元抽象类
 * ConcreateFlyweight：具体享元类
 * UnsharedConcreateFlyweight：非共享具体享元类
 * FlyweightFactory：享元工厂类
 * */
public class MainTest {
    public static void main(String[] args) {
        Set<String> set = ZuDao.pool.keySet();

        AbstractWaitressFlyweight flyweight = ZuDao.get(set.toArray()[0].toString());
        flyweight.service();
    }
}
