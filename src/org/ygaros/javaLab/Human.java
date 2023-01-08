package org.ygaros.javaLab;

public class Human {
    Animal animal;
    String name;

    Car car;

    public Human(Animal animal, String name, Car car) {
        this.animal = animal;
        this.name = name;
        this.car = car;
    }

    void feedAnimal(){
        this.animal.feed();
    }
    void takeAnimalForAWalk(){
        this.animal.takeForAWalk();
    }
}
