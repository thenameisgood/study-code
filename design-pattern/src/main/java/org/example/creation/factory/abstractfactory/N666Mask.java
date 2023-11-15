package org.example.creation.factory.abstractfactory;

public class N666Mask extends AbstractMask{

    public N666Mask() {
        this.name = "N666口罩";
    }

    @Override
    public void protectMan() {
        System.out.println("N666保护");
    }
}
