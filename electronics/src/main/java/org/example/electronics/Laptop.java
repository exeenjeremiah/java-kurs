package org.example.electronics;

public class Laptop extends ElectronicDevice implements Usable {
    private final int ramSize;

    public Laptop(String brand, String model, int year, double batteryLevel, double batteryCapacity, int ramSize) {
        super(brand, model, year, DeviceType.LAPTOP, batteryLevel, batteryCapacity);
        this.ramSize = ramSize;
    }

    @Override
    public void use(double hours) {
        if (hours < 0) {
            System.out.println("Czas pracy nie może być ujemny!");
            return;
        }

        if (batteryLevel <= 0) {
            System.out.println("Bateria laptopa jest rozładowana!");
            return;
        }

        double energy = deviceType.calculateConsumption(hours);

        if (energy >= batteryLevel) {
            batteryLevel = 0;
            System.out.println("Bateria rozładowała się podczas pracy!");
            return;
        }

        batteryLevel -= energy;
        System.out.println("Laptop był używany.");

        System.out.printf("Poziom baterii: %.1f Wh", batteryLevel);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Laptop %s %s%nRok: %d%nRAM: %d GB%nBateria: %.1f Wh%n",
                brand, model, year, ramSize, batteryLevel);
    }
}