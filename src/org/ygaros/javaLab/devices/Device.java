package org.ygaros.javaLab.devices;

public abstract class Device {
    final String model;
    final String producer;

    public Device(String model, String producer) {
        this.model = model;
        this.producer = producer;
    }

    public abstract void turnOn();

    @Override
    public String toString() {
        return "Device{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
