package org.example.parcelshop;

import java.math.BigDecimal;

public class PercentageDiscount implements Discount {
    @Override
    public BigDecimal calculate(BigDecimal productsValue) {
        BigDecimal discount = productsValue.multiply(new BigDecimal("0.10"));
        return discount.min(new BigDecimal("50.00"));
    }

    @Override
    public String getName() {
        return "Rabat 10% (Maksymalny rabat 50 zł)";
    }
}