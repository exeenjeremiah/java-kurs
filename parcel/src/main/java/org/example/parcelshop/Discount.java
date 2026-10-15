package org.example.parcelshop;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal calculate(BigDecimal productsValue);
    String getName();
}