package org.example.creation.factory.factorymethod;

/**
 * 工厂方法
 * <p>
 * 抽象工厂四个角色：
 * 抽象产品
 * 具体产品
 * 抽象工厂
 * 具体工厂
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractFactory wulingMiniCarFactory = new WulingMiniCarFactory();
        AbstractCar miniCar = wulingMiniCarFactory.newCar();
        miniCar.run();
        System.out.println(miniCar);

        AbstractFactory wulingVanCarFactory = new WulingVanCarFactory();
        AbstractCar vanCar = wulingVanCarFactory.newCar();
        vanCar.run();
        System.out.println(vanCar);
    }
}
