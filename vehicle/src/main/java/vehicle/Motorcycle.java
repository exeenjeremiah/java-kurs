package vehicle;

public class Motorcycle extends Vehicle implements Drivable {
    private final double fuelConsumption = 2.0;

    public Motorcycle(String brand, String model, int year, FuelType fuelType, double tankCapacity, double fuelLevel) {
        super(brand, model, year, fuelType, tankCapacity, fuelLevel);
    }

    @Override
    public void drive() {
        System.out.println("Motocykl zaczyna jechac.");

        if (consumeFuel(fuelConsumption)) {
            System.out.println("Motocykl jedzie");
        }
    }
}