package org.ygaros.javaLab.devices;

public class Electric extends Car{
    public Electric(String model, String producer, Double value) {
        super(model, producer, value);
    }

    @Override
    public void refuel() {
        System.out.println("ladowanie akumulatora");
    }

    @Override
    public String toString() {
        return "Electric{" +
                "owners=" + owners +
                ", model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", value=" + value +
                '}';
    }
}
