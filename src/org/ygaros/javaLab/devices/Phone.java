package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;

import java.util.List;

public class Phone extends Device{

    private static final String DEFAULT_LATEST_VERSION = "latest-stable";
    private static final String DEFAULT_APP_SERVER = "https://my.default.server.com";

    public Phone(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void turnOn() {
        System.out.println("click!");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    public void installAnApp(String appName){
        this.installAnApp(appName, DEFAULT_LATEST_VERSION);
    }
    public void installAnApp(String appName, String version){
        this.installAnApp(appName, version, DEFAULT_APP_SERVER);
    }
    public void installAnApp(String appName, String version, String server){
        System.out.printf("proba instalacji aplikacji %s we wersji %s z servera %s\n",
                appName,
                version,
                server
        );
        System.out.println("sprawdzam miesjce w pamieci");
        System.out.println("kontrola rodzicielska");
        System.out.println("pobieranie aplikacji");
        System.out.println("instalowanie aplikacji");
    }
    public void installAnApp(List<String> appNames){
        appNames.forEach(this::installAnApp);
    }


    @Override
    public void sell(Human seller, Human buyer, Double price) {
        //TODO to be implemented
    }
}
