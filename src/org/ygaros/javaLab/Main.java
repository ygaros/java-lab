package org.ygaros.javaLab;

import org.ygaros.javaLab.creatures.Pet;
import org.ygaros.javaLab.devices.Application;
import org.ygaros.javaLab.devices.Car;
import org.ygaros.javaLab.devices.LPG;
import org.ygaros.javaLab.devices.Phone;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human hum = new Human(
                new Pet(125d, "dog", "burek"),
                "franek",
                2000d
        );
        Human andrzej = new Human(
                new Pet(100d, "cat", "mialek"),
                "andrzej",
                25000d
        );
        andrzej.setCash(100000d);
        Car honda = new LPG("civic", "honda", 1500d);
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
        hum.setCar(honda, 0);
        honda.owners.add(hum);
        hum.getGarage()[0].sell(hum, andrzej, 2000d);
        System.out.println(hum.toString());
        System.out.println(hum.animal.toString());
        System.out.println(honda.toString());

        Phone xiaomi = new Phone("a9", "xiaomi", 500d);
        List<Application> apps = List.of(
                new Application("insta", "lastest", 0d),
                new Application("facebok", "lastest", 0d),
                new Application("racegame", "lastest", 0d),
                new Application("expensivegame", "lastest", 10d),
                new Application("moreexpensicegame", "lastest", 110d)
        );
        xiaomi.installAnApp(andrzej, apps.toArray(new Application[]{}));
        xiaomi.showAppNamesInPriceOrderDesc();
        xiaomi.showAppNamesInAlphabeticOrder();
        xiaomi.showAllFreeApps();
    }
}

