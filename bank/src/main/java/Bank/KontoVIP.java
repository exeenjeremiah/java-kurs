package Bank;

public class KontoVIP extends Konto {
    private final double oprocentowanieIndywidualne;
    private final double limitDebetu;

    public KontoVIP(Osoba wlasciciel, double stan,
                    double oprocentowanieIndywidualne,
                    double limitDebetu) {

        super(wlasciciel, stan);

        if (!Double.isFinite(oprocentowanieIndywidualne)
                || oprocentowanieIndywidualne < 0
                || !Double.isFinite(limitDebetu)
                || limitDebetu > 0
                || stan < limitDebetu) {
            throw new IllegalArgumentException("nieprawidlowe dane konta VIP");
        }

        this.oprocentowanieIndywidualne = oprocentowanieIndywidualne;
        this.limitDebetu = limitDebetu;
    }

    @Override
    public boolean wyplata(double kwota) {
        if (!Double.isFinite(kwota) || kwota <= 0
                || getStan() - kwota < limitDebetu) {
            return false;
        }

        setStan(getStan() - kwota);
        return true;
    }

    @Override
    public boolean przelew(Rachunek odbiorca, double kwota) {
        return super.przelew(odbiorca, kwota);
    }

    @Override
    public void aktualizacja() {
        if (getStan() > 0) {
            setStan(getStan() + getStan()
                    * oprocentowanieIndywidualne / 100);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "konto vip , właściciel: %s , stan: %.2f zł, oprocentowanie: %.2f%%, limit debetu: %.2f zł",
                getWlasciciel(), getStan(), oprocentowanieIndywidualne, limitDebetu
        );
    }
}