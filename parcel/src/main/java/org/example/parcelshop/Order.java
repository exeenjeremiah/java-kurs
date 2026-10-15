package org.example.parcelshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Order {
    private final String customerName;
    private final BigDecimal productsValue;
    private Delivery delivery;
    private Discount discount;

    public Order(Discount discount, Delivery delivery, BigDecimal productsValue, String customerName) {
        this.discount = discount;
        this.delivery = delivery;
        this.productsValue = productsValue;
        this.customerName = customerName;
    }

    public BigDecimal calculateFinalPrice() {
        BigDecimal discountValue = discount.calculate(productsValue);
        return productsValue
                .subtract(discountValue)
                .add(delivery.getCost());
    }

    public void changeDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void changeDiscount(Discount discount) {
        this.discount = discount;
    }

    public void showOrder() {
        System.out.printf("%n--- Zamówienie ---%n");
        System.out.printf("Klient: %s%n", customerName);
        System.out.printf("Wartość produktów: %s zł%n", productsValue.setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Dostawa: %s%n", delivery.getName());
        System.out.printf("Koszt dostawy: %s zł%n", delivery.getCost().setScale(2,RoundingMode.HALF_UP));
        System.out.printf("Rabat: %s%n", discount.getName());
        System.out.printf("Kwota rabatu: %s zł%n", discount.calculate(productsValue).setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Cena końcowa: %s zł%n", calculateFinalPrice().setScale(2, RoundingMode.HALF_UP));
    }
}