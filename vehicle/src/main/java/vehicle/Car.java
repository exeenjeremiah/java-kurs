package vehicle;

public class Car extends Vehicle implements Drivable {
    private final int doors;
    private final double fuel_consumption = 5.0;

    public Car(String brand, String model, int year,
               FuelType fuelType, double tankCapacity,
               double fuelLevel, int doors) {
        super(brand, model, year, fuelType, tankCapacity, fuelLevel);

        if (doors <= 0) {
            System.out.println("Liczba drzwi musi byc dodatnia.");
        }
        this.doors = doors;
    }

    @Override
    public void drive() {
        System.out.println("Samochod zaczyna jechac.");

        if (consumeFuel(fuel_consumption)) {
            System.out.println("Samochod jedzie");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Liczba drzwi: " + doors);
    }
}