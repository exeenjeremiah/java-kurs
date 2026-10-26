package org.example;

import java.util.Scanner;

public class StudyTaskMenu {
    private final StudyTaskManager manager;
    private final Scanner scanner;

    public StudyTaskMenu(StudyTaskManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("""
                    1. Dodaj zadanie
                    2. Pokaż zadania i wybierz filtr
                    3. Oznacz jako ukończone
                    4. Usuń zadanie
                    5. Dodaj tag
                    6. Usuń tag
                    7. Znajdź po tagu
                    8. Pokaż wszystkie użyte tagi
                    0. Wyjście
                    """);
            System.out.print("Wybierz opcję: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Podaj tytuł: ");
                    String title = scanner.nextLine();
                    manager.addTask(title);
                }
                case "2" -> {
                    System.out.print("""
                            1. Wszystkie zadania
                            2. Aktywne
                            3. Ukończone
                            0. Powrót
                            """);

                    System.out.print("Wybierz filtr: ");
                    String filter = scanner.nextLine();

                    switch (filter) {
                        case "1" -> manager.showAllTasks();
                        case "2" -> manager.showActiveTasks();
                        case "3" -> manager.showCompletedTasks();
                        case "0" -> System.out.println("Powrót");
                        default -> System.out.println("Zły wybór filtra");
                    }
                }

                case "3" -> {
                    System.out.print("Podaj ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    manager.completeTask(id);
                }

                case "4" -> {
                    System.out.print("Podaj ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    manager.removeTask(id);
                }

                case "5" -> {
                    System.out.print("Podaj ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    StudyTask task = manager.findById(id);

                    if (task != null) {
                        System.out.print("Podaj tag: ");
                        String tag = scanner.nextLine();
                        task.addTag(tag);
                    } else {
                        System.out.printf("Nie znaleziono zadania%n");
                    }
                }

                case "6" -> {
                    System.out.print("Podaj ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    StudyTask task = manager.findById(id);

                    if (task != null) {
                        System.out.print("Podaj tag: ");
                        String tag = scanner.nextLine();
                        task.removeTag(tag);
                    } else {
                        System.out.printf("Nie znaleziono zadania%n");
                    }
                }

                case "7" -> {
                    System.out.print("Podaj tag: ");
                    String tag = scanner.nextLine();
                    manager.showTasksByTag(tag);
                }

                case "8" -> manager.showAllTags();

                case "0" -> {
                    System.out.println("Koniec programu ");
                    return;
                }

                default -> System.out.println("Zły wybór: ");
            }
        }
    }
}