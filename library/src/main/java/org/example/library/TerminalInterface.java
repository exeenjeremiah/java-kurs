package org.example.library;

import java.util.Scanner;

public class TerminalInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryService library;

    public TerminalInterface(LibraryService library) {
        this.library = library;
    }

    public void start() {
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n1. Wyświetl dostępne elementy");
            System.out.println("2. Wyświetl wypożyczone elementy");
            System.out.println("3. Wypożycz element");
            System.out.println("4. Zwróć element");
            System.out.println("5. Wyświetl liczbę ksiązek i filmów");
            System.out.println("6. Wyjście z programu");
            System.out.print("Wybierz opcję:");

            if (!scanner.hasNextInt()) {
                System.out.println("Błąd: podaj cyfrę!");
                scanner.nextInt();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    for (LibraryItem item : library.listItems(false)) {
                        if (item != null) {
                            System.out.println(item.getInfo());
                        }
                    }
                }

                case 2 -> {
                    for (LibraryItem item : library.listItems(true)) {
                        if (item != null) {
                            System.out.println(item.getInfo());
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Podaj tytuł do wypożyczenia: ");
                    library.borrowItem(scanner.nextLine());
                }

                case 4 -> {
                    System.out.print("Podaj tytuł do zwrotu: ");
                    library.returnItem(scanner.nextLine());
                }

                case 5 -> {
                    System.out.println("Liczba książek: " + Book.getCount());
                    System.out.println("Liczba filmów: " + Movie.getCount());
                }

                case 6 -> System.out.println("Koniec działania programu");

                default -> System.out.println("Nie ma tutaj takiej opcji.");
            }
        }
    }
}