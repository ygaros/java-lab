package org.ygaros.javaLab.devices;

public class Diesel extends Car{
    public Diesel(String model, String producer, Double value) {
        super(model, producer, value);
    }

    @Override
    public void refuel() {
        System.out.println("tankowanie diesla");
    }
}
