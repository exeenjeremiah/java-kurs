package org.example.library;

public class Book extends LibraryItem {
    private String author;
    private int pages;
    private int count = 0;

    public Book(String title, boolean borrowed, String author, int pages, int count) {
        super(title, borrowed);
        this.author = author;
        this.pages = pages;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String getInfo() {
        return String.format("Książka: %s%nAutor: %s%nLiczba stron: %d%nStatus: %s", getTitle(), author, pages,
                isBorrowed() ? "Wypożyczona" : "Dostępna");
    }
}