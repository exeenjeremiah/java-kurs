package org.example;

public class Main {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();
        UserInterface ui = new UserInterface(center);
        ui.start();
    }
}