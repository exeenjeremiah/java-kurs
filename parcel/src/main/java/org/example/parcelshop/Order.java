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

    private String formatMoney(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP) + " zł";
    }

    public String toString () {
        return """
                Klient: %s
                Wartość produktów: %s
                Dostawa: %s
                Koszt dostawy: %s
                Rabat: %s
                Kwota rabatu: %s
                Cena końcowa: %s
                """.formatted(
                customerName,
                formatMoney(productsValue),
                delivery.getName(),
                formatMoney(delivery.getCost()),
                discount.getName(),
                formatMoney(discount.calculate(productsValue)),
                formatMoney(calculateFinalPrice()));
    }
}