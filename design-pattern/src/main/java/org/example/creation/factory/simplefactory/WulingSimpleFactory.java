package org.example.creation.factory.simplefactory;

/**
 * 简单工厂
 * 如果创建更多的产品，就违反了开闭原则，扩展难
 * 如果需要更多的产品，我们希望应该直接扩展一个类
 */
public class WulingSimpleFactory {

    public AbstractCar newCar(String type) {
        if ("van".equals(type)) {
            return new VanCar();
        }
        if ("mini".equals(type)) {
            return new MiniCar();
        }
        return null;
    }
}
