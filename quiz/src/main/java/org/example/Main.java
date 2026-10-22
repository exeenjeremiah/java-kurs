package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuizAnalyse analyzer = new QuizAnalyse();

    public static void main(String[] args) {
        int[] results = readResults();
        int option;

        do {
            showMenu();
            option = readNumber("Wybierz opcje");

            switch (option) {
                case 1 -> showResults(results);
                case 2 -> showStatistics(results);
                case 3 -> showUniqueResults(results);
                case 4 -> showFrequencies(results);
                case 5 -> changeResult(results);
                case 0 -> System.out.println("Koniec dzialania programu");
                default -> System.out.println("Nie ma takiej opcji");
            }

        } while (option != 0);

        System.out.println("Koniec dzialania programu");
    }

    private static int[] readResults() {
        int people = readNumberInRange("Liczba osob : (1-20): ", 1, 20);
        int[] results = new int[people];

        for (int i = 0; i < results.length; i++) {
            results[i] = readNumberInRange("Wynik osoby " + (i + 1) + " (0-100): ", 0, 100);
        }
        return results;
    }

    private static void showMenu() {
        System.out.print("""
                
                Menu:
                1. Pokaż wyniki
                2. Pokaż statystyki
                3. Pokaż unikalne wyniki
                4. Pokaż ile razy są dane wyniki
                5. Zmień wynik
                0. Koniec
                """);
    }

    private static void showResults(int[] results) {
        System.out.print("\nWyniki:\n");

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Osoba %d: %d%n", i + 1, results[i]);
        }
    }

    private static void showStatistics(int[] results) {
        double average = analyzer.average(results);
        int passed = analyzer.countPassed(results);
        int[] ranges = analyzer.scoreRanges(results);

        System.out.printf("""
                        
                        Statystyki:
                        Suma: %d
                        Średnia: %.1f
                        Min: %d
                        Max: %d
                        Zaliczyło: %d
                        Nie zaliczyło: %d
                        Ocena: %s
                        
                        Wyniki 0-49: %d
                        Wyniki 50-79: %d
                        Wyniki 80-100: %d
                        Procent zaliczeń: %.1f%%
                        """,
                analyzer.sum(results),
                average,
                analyzer.min(results),
                analyzer.max(results),
                passed,
                results.length - passed,
                analyzer.evaluateAverage(average),
                ranges[0], ranges[1], ranges[2],
                analyzer.passingPercentage(results));
    }

    private static void showUniqueResults(int[] results) {
        Set<Integer> unique = analyzer.uniqueResults(results);

        System.out.printf("""
                
                Unikalne wyniki:
                Zbiór: %s
                Ile różnych wyników: %d
                """, unique, unique.size());
    }

    private static void showFrequencies(int[] results) {
        Map<Integer, Integer> counts = analyzer.frequencies(results);
        int max = 0;

        System.out.print("\nIle razy był dany wynik:\n");

        for (int score : counts.keySet()) {
            int count = counts.get(score);
            System.out.printf("%d - %d razy%n", score, count);

            if (count > max) {
                max = count;
            }
        }

        for (int score : counts.keySet()) {
            if (counts.get(score) == max) {
                System.out.println(score + " ");
            }
        }
        System.out.printf("(" + max + " razy)");
    }

    private static void changeResult(int[] results) {
        int person = readNumberInRange("Podaj numer osoby od 1 do " + results.length + ": ", 1, results.length);
        int newScore = readNumberInRange("Nowy wynik (0-100): ", 0, 100);

        results[person - 1] = newScore;
        System.out.println("Zmieniono wynik osoby " + person + " na " + newScore);
    }

    private static int readNumberInRange(String message, int min, int max) {
        while (true) {
            int number = readNumber(message);

            if (number >= min && number <= max) {
                return number;
            }
            System.out.println("Podaj liczbe od " + min + " do " + max);
        }
    }

    private static int readNumber(String message) {
        while (true) {
            System.out.println(message);
            String text = scanner.nextLine().trim();
            Scanner check = new Scanner(text);

            if (check.hasNextInt()) {
                int number = check.nextInt();
                if (!check.hasNext()) {
                    check.close();
                    return number;
                }
            }
            check.close();
            System.out.println("Wpisz liczbe calkowita");
        }
    }
}