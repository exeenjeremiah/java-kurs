package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ticket cinema = new Ticket("Kino", 25, 10);
        Ticket concert = new Ticket("Koncert", 80, 3);

        System.out.println("Wydarzenie: " + cinema.getEventName());

        int cinemaCost = cinema.calculateCost(3);
        System.out.println("Koszt 3 biletów do kina: " + cinemaCost);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę biletów na koncert: ");
        int quantity = scanner.nextInt();

        if (quantity > 0) {
            int concertCost = concert.calculateCost(quantity);
            System.out.println("Koszt biletów: " + concertCost);
            if (concert.buy(quantity)) {
                System.out.println("Zakup został udany.");
            } else {
                System.out.println("Odmowa zakupu");
            }
        } else {
            System.out.println("Błędna liczba danych");
        }
        System.out.println("Pozostałe miejsca w kinie: " + cinema.getAvailableSeats());
        System.out.println("Pozostałe miejsca na koncercie: " + concert.getAvailableSeats());
        scanner.close();
    }
}