package vehicle;

import java.math.BigDecimal;

public enum FuelType {
    PETROL("7.20"),
    DIESEL("9.14"),
    ELECTRIC("1.05");
    private final BigDecimal price;

    FuelType(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal refuelCost(double liters) {
        return price.multiply(BigDecimal.valueOf(liters));
    }
}