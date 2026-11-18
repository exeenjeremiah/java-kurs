package org.example.parcelshop;

import java.math.BigDecimal;

public class AmountDiscount implements Discount {
    @Override
    public BigDecimal calculate(BigDecimal productsValue) {
        return productsValue.min(new BigDecimal("20.00"));
    }

    @Override
    public String getName() {
        return "Rabat kwotowy 20 zł";
    }
}