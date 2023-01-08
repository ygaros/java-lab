package org.ygaros.javaLab;

public class Animal {
    Double weight;
    String species;
    Boolean isAlive;
    String name;

    public Animal(Double weight, String species, String name) {
        this.weight = weight;
        this.species = species;
        this.name = name;
        this.isAlive = weight > 0;
    }

    void feed(){
        if(!this.isAlive) {
            System.out.println("Are you insane?");
            return;
        }
        this.weight += 2;
        System.out.println("Thanks for food!");
    }

    void takeForAWalk(){
        if(this.weight <= 0){
            System.out.println("Are you insane?");
        }else{
            this.weight -= 2;
            System.out.println("Thanks for a walk!");
            this.isAlive = this.weight > 0;
        }
    }
}
