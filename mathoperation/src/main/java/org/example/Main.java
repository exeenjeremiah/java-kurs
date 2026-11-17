package org.example;

public class Main {
    public static int calculate(int a, int b, MathOperation operation) {
        return operation.apply(a, b);
    }

    public static void main(String[] args) {

        System.out.println(calculate(14, 2, Operation.fromSign('+')));
        System.out.println(calculate(14, 2, Operation.fromSign('*')));
        System.out.println(calculate(14, 2, Operation.fromSign('-')));
        System.out.println(calculate(14, 2, Operation.fromSign('/')));

        try {
            System.out.println(calculate(14, 0, Operation.DIVIDE));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}