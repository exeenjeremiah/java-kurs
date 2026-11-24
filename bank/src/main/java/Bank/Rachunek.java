package Bank;

public class Rachunek {
    private final Osoba wlasciciel;
    private double stan;

    public Rachunek(Osoba wlasciciel, double stan) {
        if (wlasciciel == null || !Double.isFinite(stan)) {
            throw new IllegalArgumentException("Nieprawidłowe dane rachunku");
        }

        this.wlasciciel = wlasciciel;
        this.stan = stan;
    }

    public Osoba getWlasciciel() {
        return wlasciciel;
    }

    public double getStan() {
        return stan;
    }

    protected void setStan(double stan) {
        this.stan = stan;
    }

    public boolean wplata(double kwota) {
        if (!Double.isFinite(kwota) || kwota <= 0 || !Double.isFinite(stan + kwota)) {
            return false;
        }

        stan += kwota;
        return true;
    }

    public boolean wyplata(double kwota) {
        if (!Double.isFinite(kwota) || kwota <= 0 || stan < kwota) {
            return false;
        }

        stan -= kwota;
        return true;
    }

    public boolean przelew(Rachunek odbiorca, double kwota) {
        if (odbiorca == null || odbiorca == this) {
            return false;
        }

        if (!odbiorca.wplata(kwota)) {
            wplata(kwota);
            return false;
        }
        return true;
    }

    public void aktualizacja() {
        System.out.println("rachunek podstawowy");
    }

    @Override
    public String toString() {
        return String.format(
                "Rachunek  wlasciciel: %s stan: %.2f zł",
                wlasciciel, stan
        );
    }
}