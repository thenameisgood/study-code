package org.example.creation.factory.abstractfactory;

public class WulingMiniCarFactory extends WulingAbstractFactory{
    @Override
    AbstractCar newCar() {
        return new MiniCar();
    }

    @Override
    AbstractMask newMask() {
        return null;
    }
}
