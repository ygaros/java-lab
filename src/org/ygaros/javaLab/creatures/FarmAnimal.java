package org.ygaros.javaLab.creatures;

public class FarmAnimal extends Animal implements Edbile{
    public FarmAnimal(Double weight, String species, String name) {
        super(weight, species, name);
    }

    @Override
    public void beEaten() {

    }
}
