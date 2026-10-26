package org.example;

public class Product {
    private String code;
    private String name;
    private int priceInGrosze;
    private int stock;

    public Product(String code, String name, int priceInGrosze, int stock) {
        this.code = code;
        this.name = name;
        this.priceInGrosze = priceInGrosze;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPriceInGrosze() {
        return priceInGrosze;
    }

    public int getStock() {
        return stock;
    }
}
