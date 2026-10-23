package org.example.library;

import java.util.Scanner;

public class TerminalInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryService library;

    public TerminalInterface(LibraryService library) {
        this.library = library;
    }

    private void displayItems(boolean borrowed) {
        for (LibraryItem item : library.listItems(borrowed)) {
            if (item != null)
                System.out.println(item);
        }
    }

    private void displayItemsCounts() {
        System.out.println("Liczba książek: " + Book.getCount());
        System.out.println("Liczba filmów: " + Movie.getCount());
    }

    private void borrowItem() {
        System.out.println("Podaj tytuł do wypożyczniea");
        library.borrowItem(scanner.nextLine());
    }

    private void returnItem() {
        System.out.println("Podaj tytuł do zwrotu");
        library.returnItem(scanner.nextLine());
    }

    public void start() {
        int choice = 0;

        while (choice != 6) {
            System.out.println("""
                    1. Wyświetl dostępne elementy
                    2. Wyświetl wypożyczone elementy
                    3. Wypożycz element
                    4. Zwróć element
                    5. Wyświetl liczbę książek i filmów
                    6. Wyjście z programu
                    """);
            System.out.print("Wybierz opcję: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Błąd: podaj cyfrę!");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayItems(false);
                case 2 -> displayItems(true);
                case 3 -> borrowItem();
                case 4 -> returnItem();
                case 5 -> displayItemsCounts();
                case 6 -> System.out.println("Koniec programu");
                default -> System.out.println("Nie ma takiej opcji");
            }
        }
    }
}