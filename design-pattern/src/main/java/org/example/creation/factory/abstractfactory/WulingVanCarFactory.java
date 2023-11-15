package org.example.creation.factory.abstractfactory;

public class WulingVanCarFactory extends WulingAbstractFactory {
    @Override
    AbstractCar newCar() {
        return new VanCar();
    }

    @Override
    AbstractMask newMask() {
        return null;
    }
}
