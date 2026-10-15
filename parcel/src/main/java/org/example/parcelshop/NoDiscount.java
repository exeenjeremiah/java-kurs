package org.example.parcelshop;

import java.math.BigDecimal;

public class NoDiscount implements Discount {
    @Override
    public BigDecimal calculate(BigDecimal productsValue) {
        return BigDecimal.ZERO;
    }

    @Override
    public String getName() {
        return "Brak rabatu";
    }
}