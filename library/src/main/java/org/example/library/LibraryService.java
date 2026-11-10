package org.example.library;

import java.util.Optional;

public class LibraryService {
    private final int librarySize = 10;
    private final LibraryItem[] items = new LibraryItem[librarySize];
    private int count = 0;

    public void addItem(LibraryItem item) {
        if (count < librarySize) {
            items[count++] = item;
            return;
        }
        System.out.println("Biblioteka jest pełna");
    }

    public LibraryItem[] listItems(boolean borrowed) {
        LibraryItem[] result = new LibraryItem[librarySize];
        int i = 0;

        for (LibraryItem item : items) {
            if (item != null && item.isBorrowed() == borrowed) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }

    public void borrowItem(String title)
            throws TitleNotFoundException, AlreadyBorrowedException {
        LibraryItem item = findItem(title).orElseThrow(
                () -> new TitleNotFoundException(
                    "Nie znaleziono podanego tytułu: " + title)
        );
        item.borrow();
    }

    public void returnItem(String title)
            throws TitleNotFoundException {
        LibraryItem item = findItem(title).orElseThrow(
                () -> new TitleNotFoundException(
                    "Nie znaleziono podanego tytułu: " + title)
        );
        item.returnItem();
    }

    private Optional<LibraryItem> findItem(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.getTitle().equals(title))
                return Optional.of(item);
        }
        return Optional.empty();
    }
}