package org.ygaros.javaLab;

import org.ygaros.javaLab.devices.Car;

public class Main {

    public static void main(String[] args) {
        Human hum = new Human(
                new Animal(125d, "dog", "burek"),
                "franek",
                2000d
        );
        Car honda = new Car("civic", "honda", 1500d);
        for (int i = 0; i < 50; i++) {
            hum.animal.feed();
        }
        for (int i = 0; i < 200; i++) {
            hum.animal.takeForAWalk();
        }
        honda.turnOn();
        hum.animal.feed();
        hum.getSalary();
        hum.setSalary(3000d);
        hum.getSalary();
        hum.setCar(honda);
        System.out.println(hum.toString());
        System.out.println(hum.animal.toString());
        System.out.println(honda.toString());
    }
}

