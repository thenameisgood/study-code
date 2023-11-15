package org.example.creation.factory.factorymethod;

public class WulingMiniCarFactory extends AbstractFactory {
    @Override
    public AbstractCar newCar() {
        return new MiniCar();
    }
}
