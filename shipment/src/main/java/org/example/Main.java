package org.example;
public class Main {
    public static void main(String[] args) {
        ShipmentManager manager = new ShipmentManager();
        UserInterface ui = new UserInterface(manager);
        ui.start();
    }
}