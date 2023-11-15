package org.example.creation.factory.abstractfactory;

public class N95Mask extends AbstractMask {

    public N95Mask() {
        this.name = "N95口罩";
    }

    @Override
    public void protectMan() {
        System.out.println("N95保护");
    }
}
