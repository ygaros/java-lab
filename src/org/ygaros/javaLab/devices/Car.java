package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;

import java.util.Objects;

public abstract class Car extends Device{
    Double value;

    public Car(String model, String producer, Double value) {
        super(model, producer);
        this.value = value;
    }
    public abstract void refuel();
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

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(!seller.getCar().equals(this)){
            System.out.println("Seller nie posiada samochodu do sprzedania");
            return;
        }
        if(buyer.getCash() < price){
            System.out.println("Buyer nie ma wystarczajaca kasy");
            return;
        }
        seller.setCash(seller.getCash() + price);
        buyer.setCash(buyer.getCash() - price);
        buyer.setCar(seller.getCar());
        seller.setCar(null);
        System.out.printf("Transakcja powiodla sie samochod %s sprzedano za %.2f do %s\n",
                this.producer + " " + this.model,
                price,
                buyer.getName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return value.equals(car.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
