package org.example;

import org.example.electronics.ElectronicDevice;
import org.example.electronics.Laptop;
import org.example.electronics.Smartphone;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Acer", "ROG", 2023, 100, 100, 16);
        Smartphone smartphone = new Smartphone("Apple", "Iphone", 2026, 50, 50, 48);

        System.out.println("\n--- LAPTOP ---");
        laptop.displayInfo();

        System.out.println("\n--- SMARTFON ---");
        smartphone.displayInfo();

        System.out.println("\n===== KORZYSTANIE =====");

        System.out.println("\n--- LAPTOP ---");
        laptop.use(1);

        System.out.println("\n--- SMARTFON ---");
        smartphone.use(2);

        System.out.println("\n===== ŁADOWANIE =====");

        System.out.println("\n--- LAPTOP ---");
        laptop.charge(20);

        System.out.println("\n--- SMARTFON ---");
        smartphone.charge(10);

        System.out.println("\n===== BŁĘDNE OPERACJE =====");

        System.out.println("\n--- LAPTOP ---");
        laptop.use(-1);
        laptop.charge(100);

        System.out.println("\n--- SMARTFON ---");
        smartphone.charge(-5);

        System.out.println("\n--- Urządzenia ---");

        ElectronicDevice[] devices = {laptop, smartphone};
        for (ElectronicDevice device : devices) {
            device.displayInfo();
        }
    }
}