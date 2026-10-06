package org.example;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(fibonacci(n, memo));
    }
    public static long fibonacci(int n, long[] memo) {

        if (n <= 1) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
}