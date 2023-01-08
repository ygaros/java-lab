package org.ygaros.javaLab;

public class Human {
    Animal animal;
    String name;

    public Human(Animal animal, String name) {
        this.animal = animal;
        this.name = name;
    }
    void feedAnimal(){
        this.animal.feed();
    }
    void takeAnimalForAWalk(){
        this.animal.takeForAWalk();
    }
}
