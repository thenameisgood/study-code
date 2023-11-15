package org.example.creation.factory.abstractfactory;

public class WulingN95Factory extends WulingAbstractFactory {
    @Override
    AbstractCar newCar() {
        return null;
    }

    @Override
    AbstractMask newMask() {
        return new N95Mask();
    }
}
