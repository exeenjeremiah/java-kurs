package org.example;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Shop shop = new Shop(cart);
        UserInterface ui = new UserInterface(shop);
        ui.start();
    }
}