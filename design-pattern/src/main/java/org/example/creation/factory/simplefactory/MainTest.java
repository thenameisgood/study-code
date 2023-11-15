package org.example.creation.factory.simplefactory;

public class MainTest {
    public static void main(String[] args) {
        //简单工厂
        WulingSimpleFactory simpleFactory = new WulingSimpleFactory();
        AbstractCar van = simpleFactory.newCar("van");
        van.run();
        System.out.println(van);
        AbstractCar mini = simpleFactory.newCar("mini");
        mini.run();
        System.out.println(mini);
    }
}
