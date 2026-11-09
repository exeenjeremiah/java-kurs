package org.example;

public class Stack<T> {

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
    }

    public T pop() {
        if (head == null) {
            throw new IllegalStateException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public boolean contains(T value) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (head.value == value) {
            head = head.next;
            return true;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                return true;
            }
        }
        return false;
    }

    public void printAll() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void removeAll(T value) {
        if (head != null && head.value == value) {
            head = head.next;
        }

        Node<T> temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }
}