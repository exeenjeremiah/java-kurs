package org.example.library;

public abstract class LibraryItem {
    private final String title;
    private boolean borrowed;

    public LibraryItem(String title, boolean borrowed) {
        this.title = title;
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() {
        if (borrowed) {
            System.out.println("Element jest już wypożyczony");
            return;
        }
        borrowed = true;
        System.out.printf("Wypożyczono: %s%n", title);
    }

    public void returnItem() {
        if (!borrowed) {
            System.out.println("Element nie jest wypożyczony");
            return;
        }

        borrowed = false;
        System.out.printf("Zwrócono: %s%n", title);
    }

    @Override
    public abstract String toString();
}