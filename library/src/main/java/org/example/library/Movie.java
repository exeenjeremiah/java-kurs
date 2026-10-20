package org.example.library;

public class Movie extends LibraryItem {
    private final String director;
    private final int duration;

    private static int count = 0;

    public Movie(String title, boolean borrowed, int duration, String director) {
        super(title, borrowed);
        this.duration = duration;
        this.director = director;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getInfo() {
        return String.format("Film: %s%nReżyser: %s%nCzas trwania: %d minut%nStatus: %s%n",
                getTitle(),
                director,
                duration,
                isBorrowed() ? "Wypożyczony" : "Dostępny");
    }
}