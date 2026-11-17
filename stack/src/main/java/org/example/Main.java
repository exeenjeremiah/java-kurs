package org.example;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<>();

        stack1.push("Maciej");
        stack1.push("Michal");
        stack1.push("Zbigniew");

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

        Stack <Pair<Long, Integer>> stack2 = new Stack<>();

        stack2.push(new Pair<>(100L, 5));
        stack2.push(new Pair<>(300L, 15));
        stack2.push(new Pair<>(500L, 25));

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());

    }
}