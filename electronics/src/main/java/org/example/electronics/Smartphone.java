package org.example.electronics;

public class Smartphone extends ElectronicDevice implements Usable {
    private final double cameraMegapixels;

    public Smartphone(String brand, String model, int year, double batteryLevel,
                      double batteryCapacity, double cameraMegapixels) {
        super(brand, model, year, DeviceType.SMARTPHONE, batteryLevel, batteryCapacity);
        this.cameraMegapixels = cameraMegapixels;
    }

    @Override
    public void use(double hours) {
        if (hours < 0) {
            System.out.println("Czas pracy nie może być ujemny!");
        } else if (batteryLevel <= 0) {
            System.out.println("Bateria smartfona jest rozładowana!");
        } else {
            double energy = deviceType.calculateConsumption(hours);

            if (energy >= batteryLevel) {
                batteryLevel = 0;
                System.out.println("Bateria rozładowała się podczas pracy!");
            } else {
                batteryLevel -= energy;
                System.out.println("Smartphone był używany.");
            }
            System.out.printf("Poziom baterii: %.1f Wh", batteryLevel);
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("Smartfon %s %s%nRok: %d%nApart: %s MP%nBateria: %s Wh%n",
                brand, model, year, cameraMegapixels, batteryLevel);
    }
}