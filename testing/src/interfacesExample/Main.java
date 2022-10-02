package interfacesExample;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer("Oleg");
        Programmer programmer2 = new Programmer("Andrey");
        Programmer programmer3 = new Programmer("Sasha");

        Driver driver1 = new Driver("Anton");
        Driver driver2 = new Driver("Galya");
        Driver driver3 = new Driver("Ivan");


        Cook cook1 = new Cook("Chef");
        Cook cook2 = new Cook("Povar");
        Cook cook3 = new Cook("Petrov");

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(programmer1);
        workers.add(programmer2);
        workers.add(programmer3);

        workers.add(driver1);
        workers.add(driver2);
        workers.add(driver3);

        workers.add(cook1);
        workers.add(cook2);
        workers.add(cook3);


        for (Worker worker: workers) {
            worker.voice();
        }

        ArrayList<CanProgramming> programmers = new ArrayList<>();
        programmers.add(programmer1);
        programmers.add(programmer2);
        programmers.add(programmer3);


        ArrayList<CanCook> cookers = new ArrayList<>();
        cookers.add(cook1);
        cookers.add(cook2);
        cookers.add(cook3);


        ArrayList<CanDrive> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);

        for (int i = 0; i < drivers.size(); i++) {
            programmers.get(i).programming();
            drivers.get(i).drive();
            cookers.get(i).cook();
        }
    }
}
