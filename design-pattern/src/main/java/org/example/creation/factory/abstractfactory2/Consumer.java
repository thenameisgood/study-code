package org.example.creation.factory.abstractfactory2;

/**
 * @author: ht
 * @date: 2022/10/15 12:59
 */
public class Consumer {
    public static void main(String[] args) {
        new XiaomiFactory().productPhone().call();

        new HuaweiFactory().productPhone().call();


        new XiaomiFactory().productRouter().wifi();

        new HuaweiFactory().productRouter().wifi();

        //简单工厂：用来生产同一等级结构中的任意产品，对于新加新的产品。需要覆盖已有代码
        //工厂方法模式：用来生产同一等级结构中的固定产品，支持增加任意产品
        //抽象工厂模式：围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂
    }
}

