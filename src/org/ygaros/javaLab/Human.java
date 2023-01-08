package org.ygaros.javaLab;

import org.ygaros.javaLab.devices.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human {
    Animal animal;
    String name;

    private Car car;
    Double salary;

    public Human(Animal animal, String name, Double salary) {
        this.animal = animal;
        this.name = name;
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

    public void setCar(Car car) {
        if(this.salary > car.getValue()){
            System.out.println("Udalo sie kupic za gotowke");
            this.car = car;
        }else if (this.salary > car.getValue() / 12){
            System.out.println("Udalo sie kupic na kredyt");
            this.car = car;
        }else{
            System.out.println("Zapisz sie na studia i znajdz nowa robote " +
                    "albo idz po podwyzke");
        }
    }

    public Car getCar() {
        return car;
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
                ", car=" + car +
                ", salary=" + salary +
                '}';
    }
}
