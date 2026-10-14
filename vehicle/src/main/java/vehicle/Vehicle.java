package vehicle;

import java.math.BigDecimal;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected FuelType fuelType;
    protected double tankCapacity;
    protected double fuelLevel;

    public Vehicle(String brand, String model, int year,
                   FuelType fuelType, double tankCapacity,
                   double fuelLevel) {
        if (tankCapacity <= 0) {
            System.out.println("Pojemnosc zbiornika musi byc dodatnia!");
        }

        if (fuelLevel < 0 || fuelLevel > tankCapacity) {
            System.out.println("Nieprawidlowy stan paliwa.");
        }

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
        this.fuelLevel = fuelLevel;
    }

    public void displayInfo() {
        System.out.printf(
                "Marka: %s%n" +
                        "Model: %s%n" +
                        "Rok: %d%n" +
                        "Rodzaj paliwa:  %s%n" +
                        "Stan paliwa: %.2f%n" +
                        "Pojemnosc zbiornika: %.2f%n",
                brand, model, year, fuelType, fuelLevel, tankCapacity);
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println(
                    "Ilosc tankowania musi byc dodatnia."
            );
            return;
        }

        if (fuelLevel + liters > tankCapacity) {
            System.out.println("Za duzo paliwa!");
            System.out.println(
                    "Mozesz dolac maksymalnie: "
                            + (tankCapacity - fuelLevel)
            );
            return;
        }

        fuelLevel += liters;
        System.out.printf("Zatankowano: %.2f%nAktualny stan paliwa: %.2f%nKoszt: %s%n",
                liters, fuelLevel, fuelType.refuelCost(liters));
    }

    protected boolean consumeFuel(double amount) {
        if (fuelLevel < amount) {
            System.out.println(
                    "Zabraklo paliwa. Nie mozna kontynuowac podrozy"
            );
            return false;
        }

        fuelLevel -= amount;
        System.out.println("Zuzyta ilosc paliwa: " + amount);
        System.out.println("Pozostala ilosc paliwa w baku: " + fuelLevel);
        return true;
    }
}