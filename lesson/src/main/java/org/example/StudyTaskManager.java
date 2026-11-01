package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StudyTaskManager {
    private final List<StudyTask> tasks = new ArrayList<>();
    private int nextId = 1;

    public StudyTask findById(int id) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void addTask(String title) {
        if (title.trim().isEmpty()) {
            System.out.println("Tytuł nie może być pusty");
            return;
        }
        StudyTask task = new StudyTask(nextId, title);
        tasks.add(task);
        nextId++;
    }

    public void removeTask(int id) {
        StudyTask task = findById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Zadanie zostało usunięte");
        } else {
            System.out.println("Nie znaleziono zadania");
        }
    }

    public void completeTask(int id) {
        StudyTask task = findById(id);
        if (task != null) {
            task.markCompleted();
        } else {
            System.out.println("Nie znaleziono zadania");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Brak zadań");
            return;
        }
        for (StudyTask task : tasks) {
            System.out.printf("ID: %d Tytuł: %s Tagi: %s Status: ", task.getId(), task.getTitle(), task.getTags());
            if (task.isCompleted()) {
                System.out.println("Ukończone");
            } else {
                System.out.println("Aktywne");
            }
        }
    }

    public void showActiveTasks() {
        for (StudyTask task : tasks) {
            if (!task.isCompleted()) {
                System.out.printf("ID: %d Tytuł: %s%n", task.getId(), task.getTitle());
            }
        }
    }

    public void showCompletedTasks() {
        for (StudyTask task : tasks) {
            if (task.isCompleted()) {
                System.out.printf("ID: %d Tytuł: %s%n", task.getId(), task.getTitle());
            }
        }
    }

    public void showTasksByTag(String tag) {
        tag = tag.trim().toLowerCase();
        if (tag.isEmpty()) {
            System.out.println("Tag nie może być pusty");
            return;
        }
        for (StudyTask task : tasks) {
            if (task.getTags().contains(tag)) {
                System.out.printf("ID: %d Tytuł: %s%n", task.getId(), task.getTitle());
            }
        }
    }

    public void showAllTags() {
        Set<String> allTags = new TreeSet<>();
        for (StudyTask task : tasks) {
            allTags.addAll(task.getTags());
        }
        if (allTags.isEmpty()) {
            System.out.println("Brak tagów");
        } else {
            System.out.printf("Wszystkie tagi: %s%n", allTags);
        }
    }
}