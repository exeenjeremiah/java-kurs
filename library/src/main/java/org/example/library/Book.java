package org.example.library;

public class Book extends LibraryItem {
    private final String author;
    private final int pages;
    private static int count = 0;

    public Book(String title, boolean borrowed, String author, int pages) {
        super(title, borrowed);
        this.author = author;
        this.pages = pages;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getInfo() {
        return String.format("Książka: %s%nAutor: %s%nLiczba stron: %d%nStatus: %s%n", getTitle(), author, pages,
                isBorrowed() ? "Wypożyczona" : "Dostępna");
    }
}