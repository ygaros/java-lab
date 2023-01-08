package org.ygaros.javaLab;

public class Main {

    public static void main(String[] args) {
        Human hum = new Human(
                new Animal(125d, "dog", "burek"),
                "franek",
                2000d
        );
        for (int i = 0; i < 50; i++) {
            hum.animal.feed();
        }
        for (int i = 0; i < 200; i++) {
            hum.animal.takeForAWalk();
        }
        hum.animal.feed();
        hum.getSalary();
        hum.setSalary(1d);
        hum.getSalary();
    }
}

