package org.example;

public class Shop {
    private final ProductCatalog catalog = new ProductCatalog();
    private final ShoppingCart cart;

    public Shop(ShoppingCart cart) {
        this.cart = cart;
    }

    public void showCatalog() {
        catalog.showCatalog();
    }

    public void showProduct(String code) {
        Product product = catalog.findProduct(code);

        if (product == null) {
            System.out.println("Nie ma produktu o takim kodzie.");
            return;
        }
        System.out.printf("Kod: %s, Nazwa: %s, Cena: %d gr, Stan: %d%n",
                product.getCode(), product.getName(), product.getPriceInGrosze(), product.getStock());

    }

    public void addToCart(String code, int quantity) {

        if (quantity <= 0) {
            System.out.println("Ilosc musi byc dodatnia.");
            return;
        }
        Product product = catalog.findProduct(code);

        if (product == null) {
            System.out.println("Nie ma produktu o takim kodzie.");
            return;
        }

        String productCode = product.getCode();
        int inCart = cart.getQuantity(productCode);

        if (quantity > product.getStock() - inCart) {
            System.out.println("Za malo sztuk w magazynie.");
            return;
        }

        cart.add(productCode, quantity);
        System.out.printf("Dodano %d szt. produktu %s.%n", quantity, productCode);
        showCart();
    }

    public void removeFromCart(String code, int quantity) {

        if (quantity <= 0) {
            System.out.println("Ilosc musi byc dodatnia.");
            return;
        }

        Product product = catalog.findProduct(code);
        if (product == null) {
            System.out.println("Nie ma produktu o takim kodzie.");
            return;
        }

        String productCode = product.getCode();
        int inCart = cart.getQuantity(productCode);

        if (inCart == 0) {
            System.out.println("Tego produktu nie ma w koszyku.");
            return;
        }

        if (quantity > inCart) {
            System.out.println("Nie ma tylu sztuk w koszyku.");
            return;
        }

        cart.remove(productCode, quantity);
        System.out.printf("Usunieto %d szt. produktu %s.%n", quantity, productCode);
    }

    public int calculateTotal() {
        return cart.calculateTotal(catalog);
    }

    public int calculateDiscount() {
        int total = calculateTotal();

        if (total >= 5000) {
            return total / 10;
        }
        return 0;
    }

    public void showCart() {

        if (cart.isEmpty()) {
            System.out.println("Koszyk jest pusty.");
            return;
        }

        for (String code : cart.getCodes()) {
            Product product = catalog.findProduct(code);
            int quantity = cart.getQuantity(code);
            int value = product.getPriceInGrosze() * quantity;
            System.out.printf("Kod: %s, Nazwa: %s, Ilość: %d, Cena: %d%n, Wartość: %d gr%n", product.getCode(),
                    product.getName(),
                    quantity, product.getPriceInGrosze(), value);
        }

        int total = calculateTotal();
        int discount = calculateDiscount();
        System.out.printf("Suma: %d gr, Rabat: %d gr, Do zaplaty: %d gr%n", total, discount, total - discount);
    }

    public void checkout() {

        if (cart.isEmpty()) {
            System.out.println("Nie można kupić pustego koszyka.");
            return;
        }

        for (String code : cart.getCodes()) {
            Product product = catalog.findProduct(code);

            if (cart.getQuantity(code) > product.getStock()) {
                System.out.println("Brakuje produktów. Zakup odrzucony.");
                return;
            }

        }
        int total = calculateTotal();
        int discount = calculateDiscount();

        for (String code : cart.getCodes()) {
            Product product = catalog.findProduct(code);
            product.decreaseStock(cart.getQuantity(code));
        }
        cart.clear();
        System.out.printf("Zakup udany. Suma: %d gr, Rabat: %d gr, Zaplacono: %d gr%n",
                total, discount, total - discount);
    }

    public void clearCart() {
        cart.clear();
        System.out.println("Koszyk wyczyszczony");
    }
}