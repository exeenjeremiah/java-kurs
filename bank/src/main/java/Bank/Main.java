package Bank;

public class Main {
    public static void main(String[] args) {

        Rachunek[] rachunki = {
                new Rachunek(new Osoba("Dominik", "Psikuta"), 1000),
                new Konto(new Osoba("Kacper", "Baltazar"), 2000),
                new KontoVIP(new Osoba("Błażej", "Buldożer"), 500, 7, -1000)
        };

        System.out.println("wpłata: " + rachunki[0].wplata(300));
        System.out.println("wypłata: " + rachunki[1].wyplata(500));
        System.out.println("Wypłata VIP: " + rachunki[2].wyplata(900));
        System.out.println("Przelew VIP: " + rachunki[2].przelew(rachunki[0], 400));

        System.out.println("wpłata VIP: " + rachunki[2].wplata(1200));

        System.out.println("Przelew: " + rachunki[0].przelew(rachunki[1], 200));

        Konto.zmienOprocentowanie(5);

        System.out.println("Po aktualizacji:");
        for (Rachunek rachunek : rachunki) {
            rachunek.aktualizacja();
            System.out.println(rachunek);
        }
    }
}