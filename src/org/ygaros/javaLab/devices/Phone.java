package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;

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

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        //TODO to be implemented
    }
}
