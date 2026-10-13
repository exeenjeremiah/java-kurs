package vehicle;

public enum FuelType {
    PETROL(7.20),
    DIESEL(9.14),
    ELECTRIC(1.05);
    private final double price;

    FuelType(double price) {
        this.price = price;
    }

    public double refuelCost(double liters) {
        return price * liters;
    }
}