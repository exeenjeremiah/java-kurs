package org.example;

public class Pair<T, V> {

    private final T key;
    private final V value;

    public Pair(T firstElement, V secondElement) {
        this.key = firstElement;
        this.value = secondElement;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }
}