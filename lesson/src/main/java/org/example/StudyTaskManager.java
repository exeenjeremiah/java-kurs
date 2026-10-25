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
            System.out.printf("Tytuł nie może być pusty%n");
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
            System.out.printf("Zadanie zostało usunięte%n");
        } else {
            System.out.printf("Nie znaleziono zadania%n");
        }
    }

    public void completeTask(int id) {
        StudyTask task = findById(id);
        if (task != null) {
            task.markCompleted();
        } else {
            System.out.printf("Nie znaleziono zadania%n");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.print("Brak zadań");
            return;
        }
        for (StudyTask task : tasks) {
            System.out.printf("ID: %d Tytuł: %s Tagi: %s Status: ", task.getId(), task.getTitle(), task.getTags());
            if (task.isCompleted()) {
                System.out.printf("Ukończone%n");
            } else {
                System.out.printf("Aktywne%n");
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
            System.out.printf("Tag nie może być pusty%n");
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
            System.out.printf("Brak tagów%n");
        } else {
            System.out.printf("Wszystkie tagi: %s%n", allTags);
        }
    }
}