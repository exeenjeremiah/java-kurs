package vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mercedes", "A45", 2026, FuelType.PETROL, 60, 10, 5);
        Motorcycle motorcycle = new Motorcycle("Honda", "CB750", 2026, FuelType.PETROL, 15, 5);

        System.out.println("--- Samochod ---");
        car.displayInfo();
        System.out.println("--- Pierwsza jazda ---");
        car.drive();
        System.out.println("--- Druga jazda ---");
        car.drive();
        System.out.println("--- Proba tankowania 60 litrów ---");
        car.refuel(60);
        System.out.println("--- Proba tankowania 20 litrów ---");
        car.refuel(20);
        System.out.println("--- Stan auta po tankowaniu ---");
        car.displayInfo();
        System.out.println("--- Następna jazda ---");
        car.drive();
        System.out.println();

        System.out.println("--- Motocykl ---");
        motorcycle.displayInfo();
        System.out.println("--- Pierwsza jazda ---");
        motorcycle.drive();
        System.out.println("--- Druga jazda ---");
        motorcycle.drive();
        System.out.println("--- Proba tankowania 10 litrów ---");
        motorcycle.refuel(10);
        System.out.println("--- Proba tankowania 30 litrów ---");
        motorcycle.refuel(20);
        System.out.println("--- Stan auta po tankowaniu ---");
        motorcycle.displayInfo();
        System.out.println("--- Następna jazda ---");
        motorcycle.drive();
        System.out.println();
    }
}