package org.example;

import java.util.Scanner;

public class UserInterface {

    private NotificationCenter center;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface(NotificationCenter center) {
        this.center = center;
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.print("""
                    1. Dodaj e-mail
                    2. Dodaj SMS
                    3. Pokaż kanaly
                    4. Usuń kanał
                    5. Wyślij do jednego
                    6. Wyślij do wszystkich
                    7. Historia
                    8. Liczniki
                    0. Wyjście
                    """);

            System.out.print("Wybierz opcję: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> addEmail();
                case "2" -> addSms();
                case "3" -> center.showChannels();
                case "4" -> removeChannel();
                case "5" -> sendToOne();
                case "6" -> sendToAll();
                case "7" -> center.showHistory();
                case "8" -> center.showCounters();
                case "0" -> running = false;

                default -> System.out.println("Nieprawidłowa opcja.");
            }
        }
    }

    private void addEmail() {

        System.out.print("Podaj alias: ");
        String alias = scanner.nextLine();

        System.out.print("Podaj adres e-mail: ");
        String address = scanner.nextLine();

        center.addEmail(alias, address);
    }

    private void addSms() {

        System.out.print("Podaj alias: ");
        String alias = scanner.nextLine();

        System.out.print("Podaj numer telefonu: ");
        String number = scanner.nextLine();

        center.addSms(alias, number);
    }

    private void removeChannel() {

        System.out.print("Podaj alias do usunięcia: ");
        String alias = scanner.nextLine();

        center.removeChannel(alias);
    }

    private void sendToOne() {

        System.out.print("Podaj alias: ");
        String alias = scanner.nextLine();

        System.out.print("Podaj wiadomość: ");
        String message = scanner.nextLine();

        center.sendToOne(alias, message);
    }

    private void sendToAll() {
        System.out.print("Podaj wiadomość: ");
        String message = scanner.nextLine();
        center.sendToAll(message);
    }
}