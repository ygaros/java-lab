package org.ygaros.javaLab.creatures;

public abstract class Animal implements Feedable{
    private final static Double DEFAULT_FOOD_WEIGHT = 2d;
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

    @Override
    public void feed(){
        this.feed(DEFAULT_FOOD_WEIGHT);
    }

    @Override
    public void feed(Double foodWeight){
        if(!this.isAlive) {
            System.out.println("Are you insane?");
            return;
        }
        this.weight += foodWeight;
        System.out.println("Thanks for food!");
    }

    public void takeForAWalk(){
        if(this.weight <= 0){
            System.out.println("Are you insane?");
        }else{
            this.weight -= 2;
            System.out.println("Thanks for a walk!");
            this.isAlive = this.weight > 0;
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", species='" + species + '\'' +
                ", isAlive=" + isAlive +
                ", name='" + name + '\'' +
                '}';
    }
}
