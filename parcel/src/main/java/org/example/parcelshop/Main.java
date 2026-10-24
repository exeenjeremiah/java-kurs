package org.example.parcelshop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(
                new PercentageDiscount(),
                new CourierDelivery(),
                new BigDecimal("300"),
                "Mateusz Zgerypała");
        System.out.println(order);

        System.out.printf("%n--- Zmiany dostaw i rabatu ---%n");
        order.changeDelivery(new ParcelLockerDelivery());
        order.changeDiscount(new AmountDiscount());
        System.out.println(order);

        order.changeDelivery(new PersonalPickup());
        order.changeDiscount(new NoDiscount());
        System.out.println(order);
    }
}