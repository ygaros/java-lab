package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Device{

    public List<Human> owners;

    public Car(String model, String producer, Double value) {
        super(model, producer, value);
        this.owners = new ArrayList<>();
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

    public boolean checkOwnership(Human human){
        return this.owners.stream().noneMatch(h -> h.equals(human));
    }

    public boolean checkSellProcess(Human seller, Human buyer){
        for (int i = 0; i < this.owners.size() - 1; i++) {
            Human oldOwner = this.owners.get(i);
            if(oldOwner.equals(seller) && this.owners.get(i + 1).equals(buyer)){
                return true;
            }
        }
        return false;
    }
    public int carTransactionHistory(){
        return this.owners.size() - 1;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(Arrays.stream(seller.getGarage()).filter(this::equals).findAny().isEmpty()){
            throw new RuntimeException("Seller nie posiada samochodu do sprzedania");
        }
        if(!this.owners.get(this.owners.size() - 1).equals(seller)){
            throw new RuntimeException("Auto jest kradzione");
        }
        if(buyer.getCash() < price){
            throw new RuntimeException("Buyer nie ma wystarczajaca kasy");
        }
        int freeGarageSpot = buyer.getFirstFreeSpotInGarage();
        if(freeGarageSpot > -1) {
            seller.setCash(seller.getCash() + price);
            buyer.setCash(buyer.getCash() - price);
            buyer.setCar(this, freeGarageSpot);
            seller.removeCar(this);
            this.owners.add(buyer);
            System.out.printf("Transakcja powiodla sie samochod %s sprzedano za %.2f do %s\n",
                    this.producer + " " + this.model,
                    price,
                    buyer.getName()
            );
        }
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
