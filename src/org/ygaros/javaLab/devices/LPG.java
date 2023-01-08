package org.ygaros.javaLab.devices;

public class LPG extends Car{
    public LPG(String model, String producer, Double value) {
        super(model, producer, value);
    }

    @Override
    public void refuel() {
        System.out.println("tankowanie gazu");
    }
}
