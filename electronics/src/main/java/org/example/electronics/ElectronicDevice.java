package org.example.electronics;

public abstract class ElectronicDevice {
    protected String brand;
    protected String model;
    protected int year;
    protected DeviceType deviceType;
    protected double batteryLevel;
    protected double batteryCapacity;

    public ElectronicDevice(String brand, String model, int year, DeviceType deviceType, double batteryLevel,
                            double batteryCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.deviceType = deviceType;
        this.batteryLevel = batteryLevel;
        this.batteryCapacity = batteryCapacity;
    }

    public abstract void displayInfo();

    public void charge(double amount) {
        if (amount < 0) {
            System.out.println("Nie można ładować ujemną wartością!");
        } else if (batteryLevel + amount > batteryCapacity) {
            System.out.println("Nie można przekroczyć pojemności baterii!");
        } else {
            batteryLevel += amount;
            System.out.println("Naładowano baterię.");
        }
    }
}