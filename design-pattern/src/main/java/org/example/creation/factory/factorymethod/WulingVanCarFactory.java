package org.example.creation.factory.factorymethod;

public class WulingVanCarFactory extends AbstractFactory{
    @Override
    public AbstractCar newCar() {
        return new VanCar();
    }
}
