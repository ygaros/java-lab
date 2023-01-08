package org.ygaros.javaLab;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human {
    Animal animal;
    String name;

    Car car;
    Double salary;

    public Human(Animal animal, String name, Car car, Double salary) {
        this.animal = animal;
        this.name = name;
        this.car = car;
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

    void feedAnimal(){
        this.animal.feed();
    }
    void takeAnimalForAWalk(){
        this.animal.takeForAWalk();
    }
}
