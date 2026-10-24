package org.example.parcelshop;

import java.math.BigDecimal;

public class PersonalPickup implements Delivery {
    @Override
    public BigDecimal getCost() {
        return BigDecimal.ZERO;
    }

    @Override
    public String getName() {
        return "Odbiór osobisty";
    }
}