package org.example.library;

import java.util.Arrays;
import java.util.Objects;
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
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(item -> item.isBorrowed() == borrowed)
                .toArray(LibraryItem[]::new);
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
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(item -> item.getTitle().equals(title))
                .findFirst();
    }
}