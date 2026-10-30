package org.example.library;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        library.addItem(new Book("Lalka", true, "Prus", 320));
        library.addItem(new Book("Pan Tadeusz", false, "Mickiewicz", 340));
        library.addItem(new Movie("Oppenheimer", true, 180, "Christoper Nolan"));
        library.addItem(new Movie("Odyssey", false, 180, "Christoper Nolan"));

        TerminalInterface terminal = new TerminalInterface(library);
        terminal.start();
    }
}