package org.example;

import java.util.Set;
import java.util.HashSet;

public class StudyTask {
    private final int id;
    private final String title;
    private boolean completed;
    private final Set<String> tags;

    public StudyTask(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.tags = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void markCompleted() {
        if (!completed) {
            completed = true;
            System.out.printf("Zadanie oznaczone jako ukończone%n");
        } else {
            System.out.printf("Zadanie jest już ukończone%n");
        }
    }

    public void addTag(String tag) {
        tag = tag.trim().toLowerCase();
        if (tag.isEmpty()) {
            System.out.printf("Tag nie może być pusty%n");
            return;
        }
        if (tags.add(tag)) {
            System.out.printf("Tag został dodany%n");
        } else {
            System.out.printf("Tag juz istnieje%n");
        }
    }

    public void removeTag(String tag) {
        tag = tag.trim().toLowerCase();
        if (tag.isEmpty()) {
            System.out.printf("Tag  nie może być pusty%n");
            return;
        }
        if (tags.remove(tag)) {
            System.out.printf("Tag został usunięty%n");
        } else {
            System.out.printf("Nie znaleziono tagu%n");
        }
    }
}