package org.example.creation.builder;

//抽象建造者
public abstract class AbstractBuilder {
    Phone phone;

    abstract AbstractBuilder customCpu(String cpu);

    abstract AbstractBuilder customMemory(String memory);

    abstract AbstractBuilder customDisk(String disk);

    abstract AbstractBuilder customCamera(String camera);

    Phone getProduct() {
        return phone;
    }
}
