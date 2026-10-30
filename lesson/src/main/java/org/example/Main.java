package org.example;

public class Main {
    public static void main(String[] args) {
        StudyTaskManager manager = new StudyTaskManager();
        StudyTaskMenu menu = new StudyTaskMenu(manager);
        menu.run();
    }
}