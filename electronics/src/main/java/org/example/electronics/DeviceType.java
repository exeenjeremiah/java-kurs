package org.example.electronics;

public enum DeviceType {
    LAPTOP(50),
    SMARTPHONE(10),
    TABLET(20);

    public final double consumption;

    DeviceType(double consumption) {
        this.consumption = consumption;
    }

    public double calculateConsumption(double hours) {
        return consumption * hours;
    }
}