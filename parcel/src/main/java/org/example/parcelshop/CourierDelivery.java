package org.example.parcelshop;

import java.math.BigDecimal;

public class CourierDelivery implements Delivery {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal("15.00");
    }

    @Override
    public String getName() {
        return "Kurier";
    }
}