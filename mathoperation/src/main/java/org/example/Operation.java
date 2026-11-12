package org.example;

public enum Operation implements MathOperation {
    ADD('+', Integer::sum),
    MULTIPLY('*', (a, b) -> a * b),
    SUBTRACT('-', (a, b) -> a - b),
    DIVIDE('/', Operation::divide);

    private static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Nie można podzielić przez zero");
        }
        return a / b;
    }

    private final char sign;
    private final MathOperation operation;

    Operation(char sign, MathOperation operation) {
        this.sign = sign;
        this.operation = operation;
    }

    @Override
    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    public static Operation fromSign(char sign) {
        for (Operation operation : values()) {
            if (operation.sign == sign) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Nieprawidlowy znak: " + sign);
    }
}