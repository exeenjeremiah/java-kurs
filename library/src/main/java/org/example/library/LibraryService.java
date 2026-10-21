package org.example.library;

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

    public void borrowItem(String title) {
        LibraryItem item = findItem(title);
        {
            if (item == null) {
                System.out.println("Nie znaleziono podanego itemu");
                return;
            }
            item.borrow();
        }
    }

    public void returnItem(String title) {
        LibraryItem item = findItem(title);
        if (item == null) {
            System.out.println("Nie znaleziono podanego tytułu");
            return;
        }
        item.returnItem();
    }

    private LibraryItem findItem(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.getTitle().equals(title))
                return item;
        }
        return null;
    }
}