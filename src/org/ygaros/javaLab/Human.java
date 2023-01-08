package org.ygaros.javaLab;

import org.ygaros.javaLab.creatures.Animal;
import org.ygaros.javaLab.devices.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Human {
    private static final int DEFAULT_GARAGE_SIZE = 2;
    Animal animal;
    String name;

    private Car[] garage;
    Double salary;

    Double cash;

    public Human(Animal animal, String name, Double salary) {
        this.animal = animal;
        this.name = name;
        this.cash = 0d;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
        this.salary = salary;
    }

    public Human(Animal animal, String name, int garageSize, Double salary) {
        this.animal = animal;
        this.name = name;
        this.garage = new Car[garageSize];
        this.salary = salary;
    }

    public Double getSalary() {
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%s wartosc wyplaty %.2f\n",
                customFormat.format(LocalDateTime.now()), this.salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if(salary <= 0){
            return;
        }
        System.out.println("Nowa wysokosc wyplaty zostala wyslane do system ksiegowego");
        System.out.println("Koniecznie potrzeba odebrac aneks do umowy od Pani Hani z kadr");
        System.out.println("ZUS i US juz wiedza o zmianie wyplaty i nie ma sensu ukywac dochodu");
        this.salary = salary;
    }

    public void setCar(Car car, int parkingSpot) {
        if(car == null){
            this.garage = null;
            return;
        }
        if(this.salary > car.getValue()){
            System.out.println("Udalo sie kupic za gotowke");
            this.garage[parkingSpot] = car;
        }else if (this.salary > car.getValue() / 12){
            System.out.println("Udalo sie kupic na kredyt");
            this.garage[parkingSpot] = car;
        }else{
            System.out.println("Zapisz sie na studia i znajdz nowa robote " +
                    "albo idz po podwyzke");
        }
    }
    public int getFirstFreeSpotInGarage(){
        for (int i = 0; i < this.garage.length; i++) {
            Car car = this.garage[i];
            if (car == null){
                return i;
            }
        }
        return -1;
    }
    public void removeCar(Car old){
        for (int i = 0; i < this.garage.length; i++) {
            Car car = this.garage[i];
            if (car == old){
                this.garage[i] = null;
                return;
            }
        }
    }
    public Car getCar(int parkingSpot){
        return this.garage[parkingSpot];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Car[] getGarage() {
        return garage;
    }

    void feedAnimal(){
        this.animal.feed();
    }
    void takeAnimalForAWalk(){
        this.animal.takeForAWalk();
    }

    @Override
    public String toString() {
        return "Human{" +
                "animal=" + animal +
                ", name='" + name + '\'' +
                ", car=" + garage +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(animal, human.animal) && Objects.equals(name, human.name) && Arrays.equals(garage, human.garage) && Objects.equals(salary, human.salary) && Objects.equals(cash, human.cash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(animal, name, salary, cash);
        result = 31 * result + Arrays.hashCode(garage);
        return result;
    }
}
