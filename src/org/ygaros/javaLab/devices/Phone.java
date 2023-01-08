package org.ygaros.javaLab.devices;

import org.ygaros.javaLab.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Phone extends Device{

    List<Application> applications;
    private static final String DEFAULT_LATEST_VERSION = "latest-stable";
    private static final String DEFAULT_APP_SERVER = "https://my.default.server.com";

    public Phone(String model, String producer, Double value) {
        super(model, producer, value);
        this.applications = new ArrayList<>();
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

    public boolean checkAppInstalled(Application app){
        return this.checkAppInstalled(app.name);
    }
    public boolean checkAppInstalled(String appName){
        return this.applications.stream().anyMatch(a -> a.name.equalsIgnoreCase(appName));
    }
    public void showAllFreeApps(){
        this.applications.stream().filter(a -> a.price == 0).forEach(System.out::println);
    }
    public void showValueOfAllApps(){
        System.out.printf(
                "Wartosc wszystkich appek to  %.2f\n",
                this.applications.stream().map(a -> a.price).reduce(0d, Double::sum)
        );
    }
    public void showAppNamesInAlphabeticOrder(){
        List<String> appNames = new ArrayList<>(this.applications.stream().map(a -> a.name).toList());
        Collections.sort(appNames);
        appNames.forEach(System.out::println);
    }
    public void showAppNamesInPriceOrderDesc(){
        this.applications.stream()
                .sorted(Comparator.comparingDouble(a -> a.price))
                .map(a -> a.name)
                .forEach(System.out::println);
    }
    public void installAnApp(Human phoneOwner, Application ...apps){
        for (Application app : apps) {
            if(phoneOwner.getCash() > app.price){
                this.installAnApp(app.name, app.version, DEFAULT_APP_SERVER);
                this.applications.add(app);
                phoneOwner.setCash(phoneOwner.getCash() - app.price);
            }
        }
    }
    private void installAnApp(String appName){
        this.installAnApp(appName, DEFAULT_LATEST_VERSION);
    }
    private void installAnApp(String appName, String version){
        this.installAnApp(appName, version, DEFAULT_APP_SERVER);
    }
    private void installAnApp(String appName, String version, String server){
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
    private void installAnApp(List<String> appNames){
        appNames.forEach(this::installAnApp);
    }


    @Override
    public void sell(Human seller, Human buyer, Double price) {
        //TODO to be implemented
    }
}
