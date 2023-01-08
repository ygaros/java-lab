package org.ygaros.javaLab.devices;

public class Car extends Device{
    Double value;

    public Car(String model, String producer, Double value) {
        super(model, producer);
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("wrrrrr!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", value=" + value +
                '}';
    }

    public Double getValue() {
        return value;
    }
}
