package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;
import org.ygaros.javaLab.Sellable;

public abstract class Device implements Sellable {
    final String model;
    final String producer;

    Double value;

    public Device(String model, String producer, Double value) {
        this.model = model;
        this.producer = producer;
        this.value = value;
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
