package org.example.library;

import java.util.Scanner;

public class TerminalInterface {
    private Scanner scanner = new Scanner(System.in);
    private LibraryService library = new LibraryService();

    public void start() {
        int choice = 0;

        while (choice != 6) {
            System.out.println("1. Wyświetl dostępne elementy");
            System.out.println("2. Wyświetl wypożyczone elementy");
            System.out.println("3. Wypożycz element");
            System.out.println("4. Zwróć element");
            System.out.println("5. Wyświetl liczbę ksiązek i filmów");
            System.out.println("6. Wyjście z programu");

            System.out.println("Podaj poprawny numer!");
            scanner.nextInt();
        }
//        switch (choice) {
//            case 1 ->
        }
    }
