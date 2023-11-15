package org.example.creation.factory.factorymethod;

public class VanCar extends AbstractCar {

    public VanCar() {
        this.engine = "一个发动机";
    }

    @Override
    public void run() {
        System.out.println("货车run");
    }
}
