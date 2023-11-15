package org.example.creation.factory.abstractfactory;

public class MainTest {
    public static void main(String[] args) {
        WulingAbstractFactory maskFactory = new WulingN95Factory();
        AbstractMask mask = maskFactory.newMask();
        mask.protectMan();

        WulingAbstractFactory carFactory = new WulingVanCarFactory();
        AbstractCar car = carFactory.newCar();
        car.run();
    }
}
