package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> temps = new ArrayList<>();
        double averageTemperature = 0;
        double highestTemperature = Double.NEGATIVE_INFINITY;
        double sum = 0;
        while (true) {
            System.out.println("Podaj temperaturę w °C");
            if (!scanner.hasNextDouble()) {
                System.out.println("Błędna temperatura. Podaj liczbę");
                scanner.nextLine();
                continue;
            }
            Double numbers = scanner.nextDouble();
            scanner.nextLine();
            temps.add(numbers);
            sum += numbers;
            averageTemperature = sum / temps.size();

            if (numbers > highestTemperature) {
                highestTemperature = numbers;
            }
            System.out.println("Czy chcesz podać kolejną temperaturę? y/n");
            char choice = scanner.nextLine().charAt(0);
            if (choice != 'y' || choice != 'n') {
                do {
                    System.out.println("Błędny znak. Podaj y lub n");
                    choice = scanner.nextLine().charAt(0);
                } while ((choice != 'y' && choice != 'n'));
            }
            if (choice == 'n') {
                System.out.println("Koniec programu");
                break;
            }
        }
        System.out.println("Średnia temperatura wynosi: " + averageTemperature);
        System.out.println("Najwyższa temperatura wynosi: " + highestTemperature);
        String positivieOrNegative = averageTemperature >= 0
                ? "Średnia temperatura jest powyżej zera."
                : "Średnia temperatura jest równa zeru lub poniżej.";
        System.out.println(positivieOrNegative);
    }
}
