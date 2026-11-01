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
            System.out.println("Zadanie oznaczone jako ukończone");
        } else {
            System.out.println("Zadanie jest już ukończone");
        }
    }

    public void addTag(String tag) {
        tag = tag.trim().toLowerCase();
        if (tag.isEmpty()) {
            System.out.println("Tag nie może być pusty");
            return;
        }
        if (tags.add(tag)) {
            System.out.println("Tag został dodany");
        } else {
            System.out.println("Tag juz istnieje");
        }
    }

    public void removeTag(String tag) {
        tag = tag.trim().toLowerCase();
        if (tag.isEmpty()) {
            System.out.println("Tag  nie może być pusty");
            return;
        }
        if (tags.remove(tag)) {
            System.out.println("Tag został usunięty");
        } else {
            System.out.println("Nie znaleziono tagu");
        }
    }
}