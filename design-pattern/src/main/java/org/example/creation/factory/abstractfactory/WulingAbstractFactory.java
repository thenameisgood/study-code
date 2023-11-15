package org.example.creation.factory.abstractfactory;

/**
 * 五菱的所有工厂   抽象工厂
 */
public abstract class WulingAbstractFactory {

    //有哪些具体工厂

    abstract AbstractCar newCar();

    abstract AbstractMask newMask();
}
