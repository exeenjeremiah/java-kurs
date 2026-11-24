package Bank;

public class Konto extends Rachunek {
    private static double oprocentowanie = 2.0;

    public Konto(Osoba wlasciciel, double stan) {
        super(wlasciciel, stan);
    }

    public static void zmienOprocentowanie(double noweOprocentowanie) {
        if (Double.isFinite(noweOprocentowanie)
                && noweOprocentowanie >= 0) {
            oprocentowanie = noweOprocentowanie;
        }
    }

    @Override
    public void aktualizacja() {
        if (getStan() > 0) {
            setStan(getStan() + getStan() * oprocentowanie / 100);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Konto , właściciel: %s , stan: %.2f zł , oprocentowanie: %.2f%%",
                getWlasciciel(), getStan(), oprocentowanie
        );
    }
}