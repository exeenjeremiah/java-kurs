package org.example;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Shop shop;

    public UserInterface(Shop shop) {
        this.shop = shop;
    }

    public void start() {
        int option;

        do {
            System.out.print("""
                    SKLEPIK SZKOLNY
                    1. Katalog
                    2. Znajdź produkt
                    3. Dodaj do koszyka
                    4. Usuń sztuki
                    5. Koszyk i suma
                    6. Kup
                    7. Wyczyść koszyk bez zakupu
                    0. Wyjście
                    Wybierz opcję:""");

            option = readNumber();
            switch (option) {
                case 1 -> shop.showCatalog();
                case 2 -> findProduct();
                case 3 -> addProduct();
                case 4 -> removeProduct();
                case 5 -> shop.showCart();
                case 6 -> shop.checkout();
                case 7 -> shop.clearCart();
                case 0 -> System.out.println("Koniec programu.");
                default -> System.out.println("Niepoprawna opcja.");
            }
        } while (option != 0);
        scanner.close();
    }

    private void findProduct() {
        System.out.println("Podaj kod");
        String code = scanner.nextLine();
        shop.showProduct(code);
    }

    private void addProduct() {
        System.out.println("Podaj kod: ");
        String code = scanner.nextLine();

        System.out.println("Podaj ilosc: ");
        int quantity = readNumber();
        shop.addToCart(code, quantity);
    }

    private void removeProduct() {
        System.out.println("Podaj kod: ");
        String code = scanner.nextLine();

        System.out.println("Podaj ilosc: ");
        int quantity = readNumber();
        shop.removeFromCart(code, quantity);
    }

    private int readNumber() {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        }
        scanner.nextLine();
        return -1;
    }
}