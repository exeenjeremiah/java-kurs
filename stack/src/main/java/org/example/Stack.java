package org.example;

public class Stack<T> {

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(head);
        head = node;
    }

    public T pop() {
        if (head == null) {
            throw new IllegalStateException();
        }
        T value = head.getValue();
        head = head.getNext();
        return value;
    }

    public boolean contains(T value) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (head.getValue()== value) {
            head = head.getNext();
            return true;
        }

        Node<T> temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                temp.setNext(temp.getNext().getNext());
                return true;
            }
        }
        return false;
    }

    public void printAll() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
        }

        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void removeAll(T value) {
        if (head != null && head.getValue() == value) {
            head = head.getNext();
        }

        Node<T> temp = head;

        while (temp != null && temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                temp.setNext(temp.getNext().getNext());
            } else {
                temp = temp.getNext();
            }
        }
    }
}