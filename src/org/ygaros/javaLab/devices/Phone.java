package org.ygaros.javaLab.devices;

public class Phone extends Device{

    public Phone(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void turnOn() {
        System.out.println("click!");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
