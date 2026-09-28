package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lastResult;

        while (true) {
            System.out.println("Podaj działanie np. 20 + 8");
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts.length != 3) {
                System.out.println("Błedny zapis.");
                continue;
            }

            double a = Double.parseDouble(parts[0]);
            char operator = parts[1].charAt(0);
            double b = Double.parseDouble(parts[2]);

            double result = switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {

                    if (b == 0) {
                        System.out.println("Błąd:dzielenia przez zero");
                        yield Double.NaN;
                    }
                    yield a / b;
                }

                case '%' -> a % b;
                case '^' -> Math.pow(a, b);
                default -> {
                    System.out.println("Błędny operator");
                    yield Double.NaN;
                }
            };

            if (Double.isNaN(result)) {
                continue;
            }

            System.out.println(a + " " + operator + " " + b);
            System.out.println(result);
            System.out.println("Czy wykonać kolejne działanie? Y/N");
            char choice = sc.nextLine().charAt(0);

            if (choice == 'N') {
                System.out.println("Przerwanie działania programu");
                lastResult = result;
                break;
            }
        }

        if (lastResult % 2 == 0) {
            System.out.println("Wynik jest parzysty");

        } else {
            System.out.println("Wynik jest nieparzysty");
        }

        String positiveOrNegative = lastResult >= 0
                ? "Wynik jest dodatni lub równy zero"
                : "Wynik jest ujemny";
        System.out.println(positiveOrNegative);
    }
}