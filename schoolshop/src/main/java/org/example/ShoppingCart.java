package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private final Map<String, Integer> cart = new HashMap<>();

    public int getQuantity(String code) {
        return cart.getOrDefault(code, 0);
    }

    public void add(String code, int quantity) {
        if (quantity > 0) {
            cart.put(code, getQuantity(code) + quantity);
        }
    }

    public void remove(String code, int quantity) {
        int currentQuantity = getQuantity(code);
        if (quantity <= 0 || quantity > currentQuantity) {
            return;
        }
        if (quantity == currentQuantity) {
            cart.remove(code);
        } else {
            cart.put(code, currentQuantity - quantity);
        }
    }

    public int calculateTotal(ProductCatalog catalog) {
        int total = 0;
        for (String code : cart.keySet()) {
            Product product = catalog.findProduct(code);
            total += product.getPriceInGrosze() * cart.get(code);
        }
        return total;
    }

    public Set<String> getCodes() {
        return cart.keySet();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public void clear() {
        cart.clear();
    }
}