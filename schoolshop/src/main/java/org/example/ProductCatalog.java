package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products = new HashMap<>();

    public ProductCatalog() {
        products.put("Z1", new Product("Z1", "Zeszyt", 500, 5));
        products.put("D1", new Product("D1", "Dlugopis", 300, 10));
        products.put("P1", new Product("P1", "Plecak", 1000, 2));
    }

    public Product findProduct(String code) {
        code = code.trim().toUpperCase();
        return products.get(code);
    }
}
