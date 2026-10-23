package org.example.parcelshop;

import java.math.BigDecimal;

public class ParcelLockerDelivery implements Delivery {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal("10.00");
    }

    @Override
    public String getName() {
        return "Paczkomat";
    }
}