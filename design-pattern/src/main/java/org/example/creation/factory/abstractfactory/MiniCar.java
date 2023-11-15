package org.example.creation.factory.abstractfactory;

import org.example.creation.factory.abstractfactory.AbstractCar;

public class MiniCar extends AbstractCar {

    public MiniCar() {
        this.engine = "两个发动机";
    }

    @Override
    public void run() {
        System.out.println("小汽车run");
    }
}
