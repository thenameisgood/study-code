package org.example.creation.builder;

public class AppleBuilder extends AbstractBuilder {

    public AppleBuilder() {
        phone = new Phone();
    }

    @Override
    AbstractBuilder customCpu(String cpu) {
        this.phone.setCpu(cpu);
        return this;
    }

    @Override
    AbstractBuilder customMemory(String memory) {
        this.phone.setMemory(memory);
        return this;
    }

    @Override
    AbstractBuilder customDisk(String disk) {
        this.phone.setDisk(disk);
        return this;
    }

    @Override
    AbstractBuilder customCamera(String camera) {
        this.phone.setCamera(camera);
        return this;
    }
}
