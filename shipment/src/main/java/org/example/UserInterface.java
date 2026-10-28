package org.example;

import java.util.Scanner;

public class UserInterface {
    private ShipmentManager manager;
    private Scanner scanner;

    public UserInterface(ShipmentManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        do {
            System.out.println("""
                    1. Dodaj list
                    2. Dodaj paczkę
                    3. Rejestr
                    4. Znajdź po ID
                    5. Koszt nienadanych
                    6. Nadaj
                    7. Historia
                    8. Odbiorcy
                    9. Usuń przesyłkę
                    0. Wyjście
                    """);

            option = readNumber("Wybierz opcję: ");

            switch (option) {
                case 1 -> addLetter();
                case 2 -> addParcel();
                case 3 -> manager.showAllShipments();
                case 4 -> findShipment();
                case 5 -> showCost();
                case 6 -> sendShipment();
                case 7 -> manager.showHistory();
                case 8 -> manager.showRecipients();
                case 9 -> removeShipment();
                case 0 -> System.out.println("Koniec programu");
                default -> System.out.println("Nie ma takiej opcji.");
            }
        } while (option != 0);
    }

    private int readNumber(String message) {

        System.out.println(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Podaj liczbę całkowitą.");
            scanner.nextLine();
            System.out.println(message);
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private void removeShipment() {

        System.out.println("Podaj ID: ");
        String id = scanner.nextLine();
        manager.removeShipment(id);
    }

    private void sendShipment() {
        System.out.println("Podaj ID: ");
        String id = scanner.nextLine();
        manager.sendShipment(id);
    }

    private void showCost() {
        System.out.printf("Koszt nienadanych: %d gr%n", manager.calculateUnsentCost());
    }

    private void findShipment() {

        System.out.println("Podaj ID: ");
        String id = scanner.nextLine();
        manager.showById(id);
    }

    private void addLetter() {
        System.out.println("Podaj ID: ");
        String id = scanner.nextLine();

        System.out.println("Podaj odbiorcę");
        String recipient = scanner.nextLine();

        int type = readNumber("1 - Zwykły, 2 - Polecony: ");

        if (type != 1 && type != 2) {
            System.out.println("Nie ma takiego rodzaju listu.");
            return;
        }

        boolean registered = type == 2;

        manager.addLetter(id, recipient, registered);
    }

    private void addParcel() {
        System.out.println("Podaj ID: ");
        String id = scanner.nextLine();

        System.out.println("Podaj odbiorcę");
        String recipient = scanner.nextLine();

        int weight = readNumber("Podaj masę w gramach");
        manager.addParcel(id, recipient, weight);
    }
}