package org.example.structure.bridge;

public class ApplePhone extends AbstractPhone{
    @Override
    String getPhone() {
        return "苹果"+sale.getSaleInfo();
    }
}
